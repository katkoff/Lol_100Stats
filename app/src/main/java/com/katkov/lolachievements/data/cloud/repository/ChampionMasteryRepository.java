package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.cloud.api.ApiService;
import com.katkov.lolachievements.data.cloud.utils.ApiUtils;
import com.katkov.lolachievements.data.mappers.ChampionMasteryDTOApiToDomainMapper;
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class ChampionMasteryRepository {

    private final ApiService apiService;
    private final ChampionMasteryDTOApiToDomainMapper masteryDTOApiToDomainMapper;

    @Inject
    public ChampionMasteryRepository(
            ApiService apiService,
            ChampionMasteryDTOApiToDomainMapper masteryDTOApiToDomainMapper) {
        this.apiService = apiService;
        this.masteryDTOApiToDomainMapper = masteryDTOApiToDomainMapper;
    }

    public Single<List<ChampionMasteryDTO>> getChampionsMastery(String encryptedSummonerId) {
        return apiService.getChampionsMasteryDTO(encryptedSummonerId, ApiUtils.API_KEY)
                .map(masteryDTOApiToDomainMapper::mapList)
                .subscribeOn(Schedulers.io());
    }
}
