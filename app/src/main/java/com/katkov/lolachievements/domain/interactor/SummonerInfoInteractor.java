package com.katkov.lolachievements.domain.interactor;

import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.domain.service.SummonerInfoService;

import javax.inject.Inject;

import io.reactivex.Single;

public class SummonerInfoInteractor {

    private final SummonerInfoService summonerInfoService;

    @Inject
    public SummonerInfoInteractor(SummonerInfoService summonerInfoService) {
        this.summonerInfoService = summonerInfoService;
    }

    public Single<Summoner> getSummonerInfo() {
        return summonerInfoService.getSummonerInfo();
    }
}
