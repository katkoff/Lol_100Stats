package com.katkov.lolachievements.presentation.summonerinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.katkov.lolachievements.domain.model.SummonerDTO;
import com.katkov.lolachievements.presentation.base.ErrorView;

public interface SummonerInfoView extends MvpView, ErrorView {

    @StateStrategyType(AddToEndStrategy.class)
    void fillSummonerInfo(SummonerDTO summonerDTO);

    @StateStrategyType(AddToEndStrategy.class)
    void showProgressBar();

    @StateStrategyType(AddToEndStrategy.class)
    void hideProgressBar();
}
