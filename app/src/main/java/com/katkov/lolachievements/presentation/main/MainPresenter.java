package com.katkov.lolachievements.presentation.main;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.katkov.lolachievements.LolApp;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.MainUseCase;
import com.katkov.lolachievements.utils.CiceroneKeys;

import javax.inject.Inject;

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
//        getViewState().showFirstFragment(mainUseCase.checkFirstEntry());
        boolean isFirstEntry = mainUseCase.checkFirstEntry();
        String firstFragment = getFirstFragmentKey(isFirstEntry);
        LolApp.INSTANCE.getRouter().navigateTo(firstFragment);
    }

    @NonNull
    private String getFirstFragmentKey(boolean isFirstEntry) {
        if (isFirstEntry) {
            return CiceroneKeys.CHOICE_SERVER_FRAGMENT;
        } else {
            return CiceroneKeys.PLAYER_INFO_FRAGMENT;
        }
    }

//    public void startChoiceServerFragment(FragmentManager fragmentManager, int fragmentContainer) {
//        ChoiceServerFragment choiceServerFragment = ChoiceServerFragment.newInstance();
//        replaceFragment(choiceServerFragment, fragmentContainer, fragmentManager);
//    }
//
//    public void startPlayerInfoFragment(FragmentManager fragmentManager, int fragmentContainer) {
//        PlayerInfoFragment playerInfoFragment = PlayerInfoFragment.newInstance();
//        replaceFragment(playerInfoFragment, fragmentContainer, fragmentManager);
//    }

    private void replaceFragment(Fragment fragment, int fragmentContainer, FragmentManager fragmentManager) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(fragmentContainer, fragment);
        ft.commitNow();
    }
}
