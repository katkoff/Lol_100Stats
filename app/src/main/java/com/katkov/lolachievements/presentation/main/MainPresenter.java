package com.katkov.lolachievements.presentation.main;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.utils.CommonTextUtils;
import com.katkov.lolachievements.utils.PreferenceKeysUtils;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router router;
    private final SharedPreferences sharedPreferences;

    @Inject
    MainPresenter(Router router, SharedPreferences sharedPreferences) {
        this.router = router;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        checkAlreadyLogged();
    }

    private void checkAlreadyLogged() {
        String summonerName = sharedPreferences.getString(PreferenceKeysUtils.SUMMONER_NAME_PREF, CommonTextUtils.UNKNOWN_VALUE);
        router.navigateTo(getFirstScreen(summonerName));
    }

    private Screen getFirstScreen(String summonerName) {
        if (summonerName.isEmpty() || summonerName.equals(CommonTextUtils.UNKNOWN_VALUE)) {
            return new Screens.FirstEntryScreen();
        } else {
            Scopes.openUserScope(summonerName);

            return new Screens.CheckFirstEntryInfoScreen();
        }
    }
}
