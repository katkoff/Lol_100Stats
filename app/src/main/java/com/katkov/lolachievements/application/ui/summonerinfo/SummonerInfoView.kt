package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView
import com.katkov.lolachievements.domain.model.SummonerModel

interface SummonerInfoView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(AddToEndStrategy::class)
    fun fillSummonerInfo(summonerModel: SummonerModel)

    @StateStrategyType(AddToEndStrategy::class)
    fun fillChestCount(chestCount: Int)
}
