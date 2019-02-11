package com.katkov.lolachievements.presentation.checkentryinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.di.BindingNamesUtils;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Router;
import toothpick.Toothpick;

@InjectViewState
public class CheckEntryInfoPresenter extends MvpPresenter<CheckEntryInfoView> {

    private final Router router;
    private final LoginUseCase loginUseCase;
    private final String summonerName;

    @Inject
    public CheckEntryInfoPresenter(
            Router router,
            LoginUseCase loginUseCase,
            @Named(BindingNamesUtils.SUMMONER_NAME) String summonerName) {
        this.router = router;
        this.loginUseCase = loginUseCase;
        this.summonerName = summonerName;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().fillInfo(summonerName);
    }

    public void onLogoutButtonClicked() {
        Toothpick.closeScope(Scopes.USER_SCOPE);
        router.navigateTo(new Screens.FirstEntryScreen());
        loginUseCase.removeSummonerNameFromPref();
    }

    public void onSummonerInfoButtonClicked(String summonerName) {
        router.navigateTo(new Screens.SummonerInfoScreen());
    }
}
