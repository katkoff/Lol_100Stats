package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.mapper.SummonerDTOMapper;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class SummonerInfoRepository {

    private final ApiService apiService;
    private final SummonerDTOMapper mapper;
    private final String apiKey = "RGAPI-22d31efb-1fce-475b-af5e-a5c26a517a9b";

    @Inject
    public SummonerInfoRepository(ApiService apiService, SummonerDTOMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    public Single<SummonerDTO> getSummonerDTO(String summonerName) {
        return apiService.getSummonerDTO(summonerName, apiKey)
                .map(apiModel -> mapper.map(apiModel))
                .subscribeOn(Schedulers.io());
    }
}
