package com.katkov.lolachievements.application.ui.firstentry;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface FirstEntryView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showServerChoiceDialog();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showSelectedName(String selectedName);
}
