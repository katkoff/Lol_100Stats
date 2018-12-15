package com.katkov.lolachievements.domain.usecase;

import com.katkov.lolachievements.data.local.dao.SummonerDao;
import com.katkov.lolachievements.data.local.database.AppDataBase;
import com.katkov.lolachievements.data.local.entity.Summoner;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class LoginUseCase {

    private AppDataBase appDataBase;

    @Inject
    public LoginUseCase(AppDataBase appDataBase) {
        this.appDataBase = appDataBase;
    }

    // временный метод. Представим, что я узнал, какой первый фрагмент нужно запускать
    public Single<Boolean> checkFirstEntry() {
        return getSummonersFromDB()
                .subscribeOn(Schedulers.io())
                .map(summoner -> summoner.isLoggedIn());
    }

    // Метод, который будет в сервисе
    // он тут только погостить :)
    private Single<Summoner> getSummonersFromDB() {
        SummonerDao summonerDao = appDataBase.summonerDao();

        summonerDao.insert(new Summoner(1, "Test", true));

        return summonerDao.getAll()
                .subscribeOn(Schedulers.io());
    }
}
