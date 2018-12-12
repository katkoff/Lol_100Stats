package com.katkov.lolachievements.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.LolApp;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.MainUseCase;

import javax.inject.Inject;

import ru.terrakok.cicerone.Screen;
import toothpick.Toothpick;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    MainUseCase mainUseCase;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
        checkFirstEntry();
    }

    public void checkFirstEntry() {
        // TODO: 09.12.2018 делаем запрос в БД
        // временный метод. Представим, что я узнал, какой первый фрагмент нужно запускать
        boolean isFirstEntry = mainUseCase.checkFirstEntry();
        Screen firstScreen = getFirstScreen(isFirstEntry);
        LolApp.INSTANCE.getRouter().navigateTo(firstScreen);
    }

    private Screen getFirstScreen(boolean isFirstEntry) {
        if (isFirstEntry) {
            return new Screens.ServerChoiceScreen();
        } else {
            return new Screens.PlayerInfoScreen();
        }
    }
}
