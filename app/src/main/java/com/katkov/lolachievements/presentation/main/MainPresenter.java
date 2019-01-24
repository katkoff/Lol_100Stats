package com.katkov.lolachievements.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router router;

    @Inject
    MainPresenter(Router router) {
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        checkSummonerAvailability();
    }

    private void checkSummonerAvailability() {
        router.navigateTo(new Screens.FirstEntryScreen());
    }

//    private Screen getFirstScreen(Summoner summoner) {
//        if (summoner.isAvailable()) {
//            return new Screens.SummonerInfoScreen(summoner);
//        } else {
//            return new Screens.FirstEntryScreen();
//        }
//    }
}
