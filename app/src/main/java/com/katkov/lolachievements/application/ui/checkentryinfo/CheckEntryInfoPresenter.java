package com.katkov.lolachievements.application.ui.checkentryinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.application.navigation.Screens;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class CheckEntryInfoPresenter extends MvpPresenter<CheckEntryInfoView> {

    private final Router router;
    private final LoginUseCase loginUseCase;
    private final EntryInfoHolder entryInfoHolder;

    @Inject
    public CheckEntryInfoPresenter(
            Router router,
            LoginUseCase loginUseCase,
            EntryInfoHolder entryInfoHolder) {
        this.router = router;
        this.loginUseCase = loginUseCase;
        this.entryInfoHolder = entryInfoHolder;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().fillInfo(entryInfoHolder.getEntryInfoModel());
    }

    public void onLogoutButtonClicked() {
        router.navigateTo(new Screens.FirstEntryScreen());
        loginUseCase.removeEntryInfo();
    }

    public void onSummonerInfoButtonClicked() {
        router.navigateTo(new Screens.SummonerInfoScreen());
    }
}
