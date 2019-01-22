package com.katkov.lolachievements.domain.usecase;

import com.katkov.lolachievements.domain.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginUseCase {

    private LoginService loginService;

    @Inject
    public LoginUseCase(LoginService loginService) {
        this.loginService = loginService;
    }

}
