package com.katkov.lolachievements.application.base

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface ProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProgressEnable(isEnable: Boolean)
}
