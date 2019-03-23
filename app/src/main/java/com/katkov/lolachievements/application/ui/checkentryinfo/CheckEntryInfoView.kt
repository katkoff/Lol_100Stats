package com.katkov.lolachievements.application.ui.checkentryinfo

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.katkov.lolachievements.domain.model.EntryInfoModel

interface CheckEntryInfoView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun fillInfo(entryInfoModel: EntryInfoModel)
}
