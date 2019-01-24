package com.katkov.lolachievements.domain.usecase;

import com.katkov.lolachievements.domain.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginUseCase {

    private final LoginService loginService;

    @Inject
    public LoginUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

    public void saveSummonerNameToPref(String summonerName) {
        loginService.saveSummonerNameToPref(summonerName);
    }
}
