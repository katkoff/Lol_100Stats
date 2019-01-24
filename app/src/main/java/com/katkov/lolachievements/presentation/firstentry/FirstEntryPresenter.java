package com.katkov.lolachievements.presentation.firstentry;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class FirstEntryPresenter extends MvpPresenter<FirstEntryView> {

    private final LoginUseCase loginUseCase;
    private final Router router;

    @Inject
    FirstEntryPresenter(LoginUseCase loginUseCase, Router router) {
        this.loginUseCase = loginUseCase;
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    public void onLoginButtonPressed(String summonerName) {
        loginUseCase.saveSummonerNameToPref(summonerName);
        router.navigateTo(new Screens.CheckFirstEntryInfoScreen());
    }
}
