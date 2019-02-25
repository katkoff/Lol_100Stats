package com.katkov.lolachievements.application.base;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ProgressVeiw {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setProgressEnable(boolean isEnable);
}
