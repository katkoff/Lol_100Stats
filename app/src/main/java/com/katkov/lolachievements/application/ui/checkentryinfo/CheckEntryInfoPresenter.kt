package com.katkov.lolachievements.application.ui.checkentryinfo

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import com.katkov.lolachievements.domain.usecase.LoginUseCase
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CheckEntryInfoPresenter
@Inject
constructor(
        private val router: Router,
        private val loginUseCase: LoginUseCase,
        private val entryInfoHolder: EntryInfoHolder) : MvpPresenter<CheckEntryInfoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.fillInfo(entryInfoHolder.getEntryInfo())
    }

    fun onLogoutButtonClicked() {
        router.navigateTo(Screens.FirstEntryScreen())
        loginUseCase.removeEntryInfo()
    }

    fun onSummonerInfoButtonClicked() {
        router.navigateTo(Screens.SummonerInfoScreen())
    }
}
