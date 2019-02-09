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
    private final String apiKey = "RGAPI-6629a33f-bcc4-4dc8-8307-719d0cf1547b";

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
