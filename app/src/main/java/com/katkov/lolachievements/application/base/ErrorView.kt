package com.katkov.lolachievements.application.base

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ErrorView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showError(error: Error)
}
