package com.katkov.lolachievements.domain.usecase;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainUseCase {

    @Inject
    public MainUseCase() {
    }

    // временный метод. Представим, что я узнал, какой первый фрагмент нужно запускать
    public boolean checkFirstEntry() {
        return true;
    }
}
