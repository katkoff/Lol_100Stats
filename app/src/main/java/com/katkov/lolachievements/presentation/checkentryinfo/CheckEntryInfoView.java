package com.katkov.lolachievements.presentation.checkentryinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface CheckEntryInfoView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void fillInfo();
}
