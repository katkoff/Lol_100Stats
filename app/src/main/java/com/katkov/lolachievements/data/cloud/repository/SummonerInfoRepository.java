package com.katkov.lolachievements.data.cloud.repository;

import com.katkov.lolachievements.data.local.entity.Summoner;

import javax.inject.Inject;

import io.reactivex.Single;

public class SummonerInfoRepository {

    @Inject
    public SummonerInfoRepository() {
    }

    public Single<Summoner> getSummonerInfo() {
        // TODO: 03-Feb-19
        return Single.just(new Summoner(1223, "sdas", 132, true));
    }
}
