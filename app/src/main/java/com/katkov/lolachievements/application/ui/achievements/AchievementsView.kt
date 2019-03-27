package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.domain.model.AchievementModel

interface AchievementsView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun fillAchievements(achievements: List<AchievementModel>)
}