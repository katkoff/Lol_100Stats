package com.katkov.lolachievements.di.auth;

import com.katkov.lolachievements.data.local.database.AppDataBase;

import toothpick.config.Module;

public class LoginModule extends Module {

    public LoginModule(AppDataBase appDataBase) {
        bind(AppDataBase.class).toInstance(appDataBase);
    }
}
