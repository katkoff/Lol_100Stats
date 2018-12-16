package com.katkov.lolachievements.domain.usecase;

import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.domain.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class LoginUseCase {

    private LoginService loginService;

    @Inject
    public LoginUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public Single<Summoner> getSummonersFromDB() {
        return loginService.getSummonersFromDB()
                .subscribeOn(Schedulers.io());
    }
}
