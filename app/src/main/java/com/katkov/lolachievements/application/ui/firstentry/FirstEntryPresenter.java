package com.katkov.lolachievements.application.ui.firstentry;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.application.navigation.Screens;
import com.katkov.lolachievements.domain.model.EntryInfoModel;
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

    public void onLoginButtonClicked(EntryInfoModel entryInfoModel) {
        loginUseCase.saveEntryInfo(entryInfoModel);
        router.navigateTo(new Screens.CheckFirstEntryInfoScreen());
    }

    public void onServerNameClicked() {
        getViewState().showServerChoiceDialog();
    }
}
