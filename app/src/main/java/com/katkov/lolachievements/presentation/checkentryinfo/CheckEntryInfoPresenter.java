package com.katkov.lolachievements.presentation.checkentryinfo;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class CheckEntryInfoPresenter extends MvpPresenter<CheckEntryInfoView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().fillInfo();
    }
}
