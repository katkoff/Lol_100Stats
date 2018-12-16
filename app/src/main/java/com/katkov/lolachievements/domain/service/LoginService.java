package com.katkov.lolachievements.domain.service;

import com.katkov.lolachievements.data.local.dao.SummonerDao;
import com.katkov.lolachievements.data.local.database.AppDataBase;
import com.katkov.lolachievements.data.local.entity.Summoner;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class LoginService {

    private AppDataBase appDataBase;

    @Inject
    public LoginService(AppDataBase appDataBase) {
        this.appDataBase = appDataBase;
    }

    public Single<Summoner> getSummonersFromDB() {
        SummonerDao summonerDao = appDataBase.summonerDao();

//         Метод используемый при первом запуске, для добавления записи в БД
        summonerDao.insert(new Summoner(1, "Test", 55, true));

        return summonerDao.getAll()
                .subscribeOn(Schedulers.io());
    }
}
