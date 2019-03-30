package com.katkov.lolachievements.application.ui.checkentryinfo

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.annotations.AfterLoggingRouter
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.LoginInteractor
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class CheckEntryInfoPresenter
@Inject
constructor(
    @GlobalRouter private val globalRouter: Router,
    @AfterLoggingRouter private val bottomNavigationRouter: Router,
    private val loginInteractor: LoginInteractor
) : MvpPresenter<CheckEntryInfoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.fillInfo(loginInteractor.getLoginModel())
    }

    fun onLogoutButtonClicked() {
        globalRouter.replaceScreen(Screens.LoginScreen())
        loginInteractor.removeLoginModel()
        Toothpick.closeScope(Scopes.AFTER_LOGGING_SCOPE)
    }

    fun onSummonerInfoButtonClicked() {
        bottomNavigationRouter.replaceScreen(Screens.SummonerInfoScreen())
    }
}
