package com.katkov.lolachievements.presentation.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
//    @StateStrategyType(OneExecutionStateStrategy.class)
    void showFirstFragment(boolean isThisFirstEntry);
}
