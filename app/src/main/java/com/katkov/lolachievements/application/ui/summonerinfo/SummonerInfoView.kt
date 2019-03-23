package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView
import com.katkov.lolachievements.domain.model.SummonerDTO

interface SummonerInfoView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(AddToEndStrategy::class)
    fun fillSummonerInfo(summonerDTO: SummonerDTO)

    //    @StateStrategyType(AddToEndStrategy.class)
    //    void showProgressBar();
    //
    //    @StateStrategyType(AddToEndStrategy.class)
    //    void hideProgressBar();

    @StateStrategyType(AddToEndStrategy::class)
    fun fillChestCount(chestCount: Int)
}
