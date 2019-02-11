package com.katkov.lolachievements.presentation.checkentryinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface CheckEntryInfoView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void fillInfo();
}
