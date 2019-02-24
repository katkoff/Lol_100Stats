package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.mappers.SummonerDTOApiToDomainMapper;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static com.katkov.lolachievements.data.cloud.utils.ApiUtils.API_KEY;

public class SummonerInfoRepository {

    private final ApiService apiService;
    private final SummonerDTOApiToDomainMapper mapper;

    @Inject
    public SummonerInfoRepository(ApiService apiService, SummonerDTOApiToDomainMapper mapper) {
        this.apiService = apiService;
        this.mapper = mapper;
    }

    public Single<SummonerDTO> getSummonerDTO(String summonerName) {
        return apiService.getSummonerDTO(summonerName, API_KEY)
                .map(mapper::map)
                .subscribeOn(Schedulers.io());
    }
}
