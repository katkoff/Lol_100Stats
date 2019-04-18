package com.katkov.lolachievements.application.ui.checkentryinfo

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.application.base.ErrorView
import com.katkov.lolachievements.application.base.ProgressView
import com.katkov.lolachievements.domain.model.LoginModel

interface CheckEntryInfoView : MvpView, ErrorView, ProgressView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun fillInfo(loginModel: LoginModel?)
}
