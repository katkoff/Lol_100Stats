package com.katkov.lolachievements.application.base;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ErrorView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showError(Error error);
}
