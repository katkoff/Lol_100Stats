package com.katkov.lolachievements.di.main;

import com.katkov.lolachievements.domain.usecase.MainUseCase;

import toothpick.config.Module;

public class MainModule extends Module {

    public MainModule() {
        bind(MainUseCase.class);
    }
}
