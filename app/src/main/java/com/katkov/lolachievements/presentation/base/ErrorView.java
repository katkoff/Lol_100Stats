package com.katkov.lolachievements.presentation.base;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ErrorView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(Error error);
}
