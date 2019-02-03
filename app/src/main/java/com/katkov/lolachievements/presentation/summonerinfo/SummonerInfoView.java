package com.katkov.lolachievements.presentation.summonerinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.katkov.lolachievements.data.local.entity.Summoner;

public interface SummonerInfoView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void fillSummonerInfo(Summoner summoner);
}
