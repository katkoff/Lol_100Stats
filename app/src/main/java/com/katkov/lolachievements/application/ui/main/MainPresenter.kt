package com.katkov.lolachievements.application.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.LoginInteractor
import com.katkov.lolachievements.domain.model.LoginModel
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject
internal constructor(
    @GlobalRouter val router: Router,
    private val loginInteractor: LoginInteractor,
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        checkAlreadyLogged()
    }

    private fun checkAlreadyLogged() {
        // try to get Summoner from DB


        val loginModel = loginInteractor.getLoginModel()
        router.newRootScreen(getFirstScreen(loginModel))
    }

    private fun getFirstScreen(loginModel: LoginModel?): Screen {
        return if (loginModel == null) {
            Screens.LoginScreen()
        } else {
            Screens.BottomNavigationFragmentScreen()
        }
    }
}
