package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.mapper.SummonerDTOApiToDomainMapper;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class SummonerInfoRepository {

    private final ApiService apiService;
    private final SummonerDTOApiToDomainMapper mapper;
    private final String apiKey = "RGAPI-70b77dc5-fc20-4051-b3cb-4ead302e5f9f";

    @Inject
    public SummonerInfoRepository(ApiService apiService, SummonerDTOApiToDomainMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    public Single<SummonerDTO> getSummonerDTO(String summonerName) {
        return apiService.getSummonerDTO(summonerName, apiKey)
                .map(apiModel -> mapper.map(apiModel))
                .subscribeOn(Schedulers.io());
    }
}
