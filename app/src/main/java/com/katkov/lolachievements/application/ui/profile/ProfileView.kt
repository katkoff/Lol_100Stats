package com.katkov.lolachievements.application.ui.profile

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView

interface ProfileView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun fillInfo(profileUiModel: ProfileUiModel)
}
