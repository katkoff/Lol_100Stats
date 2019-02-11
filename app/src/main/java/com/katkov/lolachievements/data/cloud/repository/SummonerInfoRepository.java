package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.cloud.api.model.SummonerDTOApiModel;
import com.katkov.lolachievements.data.mapper.SummonerDTOMapper;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SummonerInfoRepository {

    private final ApiService apiService;
    private final SummonerDTOMapper mapper;
    private final String apiKey = "RGAPI-16385ae8-817e-451b-9316-d97011d606f1";

    @Inject
    public SummonerInfoRepository(ApiService apiService, SummonerDTOMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    public Single<SummonerDTO> getSummonerDTO(String summonerName) {
        return apiService.getSummonerDTO(summonerName, apiKey)
                .map(new Function<SummonerDTOApiModel, SummonerDTO>() {
                    @Override
                    public SummonerDTO apply(SummonerDTOApiModel apiModel) throws Exception {
                        return mapper.map(apiModel);
                    }
                })
                .subscribeOn(Schedulers.io());
    }
}
