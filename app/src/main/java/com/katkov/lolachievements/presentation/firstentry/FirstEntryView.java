package com.katkov.lolachievements.presentation.firstentry;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface FirstEntryView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showServerChoiceDialog();
}
