package com.katkov.lolachievements.di.auth;

import com.katkov.lolachievements.data.local.database.AppDataBase;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;

import toothpick.config.Module;

public class LoginModule extends Module {

    public LoginModule(AppDataBase appDataBase) {
        bind(LoginUseCase.class).toInstance(new LoginUseCase(appDataBase));
    }
}
