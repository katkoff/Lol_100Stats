package com.katkov.lolachievements.presentation.checkentryinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import toothpick.Toothpick;

@InjectViewState
public class CheckEntryInfoPresenter extends MvpPresenter<CheckEntryInfoView> {

    private final Router router;
    private final LoginUseCase loginUseCase;

    @Inject
    public CheckEntryInfoPresenter(Router router, LoginUseCase loginUseCase) {
        this.router = router;
        this.loginUseCase = loginUseCase;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().fillInfo();
    }

    public void onLogoutButtonClicked() {
        Toothpick.closeScope(Scopes.USER_SCOPE);
        router.navigateTo(new Screens.FirstEntryScreen());
        loginUseCase.removeSummonerNameFromPref();
    }

    public void onSummonerInfoButtonClicked(String summonerName) {
        router.navigateTo(new Screens.SummonerInfoScreen(summonerName));
    }
}
