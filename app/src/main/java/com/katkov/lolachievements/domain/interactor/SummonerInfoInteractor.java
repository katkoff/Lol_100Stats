package com.katkov.lolachievements.domain.interactor;

import com.katkov.lolachievements.data.cloud.repository.SummonerInfoRepository;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

import io.reactivex.Single;

public class SummonerInfoInteractor {

    private final SummonerInfoRepository summonerInfoRepository;

    @Inject
    public SummonerInfoInteractor(SummonerInfoRepository summonerInfoRepository) {
        this.summonerInfoRepository = summonerInfoRepository;
    }

    public Single<SummonerDTO> getSummonerDTO(String name) {
        return summonerInfoRepository.getSummonerDTO(name);
    }
}
