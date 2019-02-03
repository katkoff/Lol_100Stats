package com.katkov.lolachievements.domain.interactor;

import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.data.cloud.repository.SummonerInfoRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class SummonerInfoInteractor {

    private final SummonerInfoRepository summonerInfoRepository;

    @Inject
    public SummonerInfoInteractor(SummonerInfoRepository summonerInfoRepository) {
        this.summonerInfoRepository = summonerInfoRepository;
    }

    public Single<Summoner> getSummonerInfo() {
        return summonerInfoRepository.getSummonerInfo();
    }
}
