package com.katkov.lolachievements.application.ui.login

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView

interface LoginView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showServerChoiceDialog()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSelectedName(selectedName: String)
}
