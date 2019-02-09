package com.katkov.lolachievements.presentation.summonerinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.katkov.lolachievements.domain.model.SummonerDTO;
import com.katkov.lolachievements.presentation.base.ErrorView;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface SummonerInfoView extends MvpView, ErrorView {

    void fillSummonerInfo(SummonerDTO summonerDTO);

    void showProgressBar();

    void hideProgressBar();
}
