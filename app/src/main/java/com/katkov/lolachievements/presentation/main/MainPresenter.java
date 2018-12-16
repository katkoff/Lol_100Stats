package com.katkov.lolachievements.presentation.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.Screens;
import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.LoginUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;
import toothpick.Toothpick;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Router router;

    @Inject
    LoginUseCase loginUseCase;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE));
        checkSummonerAvailability();
    }

    private void checkSummonerAvailability() {
        loginUseCase.getSummonersFromDB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(Summoner::isAvailable)
                .subscribe(new DisposableSingleObserver<Boolean>() {
                    @Override
                    public void onSuccess(Boolean isFirstEntry) {
                        router.navigateTo(getFirstScreen(isFirstEntry));
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    private Screen getFirstScreen(boolean isAvailable) {
        if (isAvailable) {
            return new Screens.PlayerInfoScreen();
        } else {
            return new Screens.ServerChoiceScreen();
        }
    }
}
