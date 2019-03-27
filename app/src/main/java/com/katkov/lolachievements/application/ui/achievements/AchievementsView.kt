package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView
import com.katkov.lolachievements.domain.model.AchievementModel

interface AchievementsView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun fillAchievements(achievements: List<AchievementModel>)
}