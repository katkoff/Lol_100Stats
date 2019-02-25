package com.katkov.lolachievements.application.ui.summonerinfo;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.katkov.lolachievements.application.base.ProgressVeiw;
import com.katkov.lolachievements.domain.model.SummonerDTO;
import com.katkov.lolachievements.application.base.ErrorView;

public interface SummonerInfoView extends MvpView, ErrorView, ProgressVeiw {

    @StateStrategyType(AddToEndStrategy.class)
    void fillSummonerInfo(SummonerDTO summonerDTO);

//    @StateStrategyType(AddToEndStrategy.class)
//    void showProgressBar();
//
//    @StateStrategyType(AddToEndStrategy.class)
//    void hideProgressBar();

    @StateStrategyType(AddToEndStrategy.class)
    void fillChestCount(int chestCount);
}
