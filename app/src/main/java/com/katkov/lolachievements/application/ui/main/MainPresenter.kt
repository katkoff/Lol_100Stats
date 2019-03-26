package com.katkov.lolachievements.application.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.model.LoginModel
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject
internal constructor(
    @GlobalRouter val router: Router,
    private val loginModelHolder: LoginModelHolder
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        checkAlreadyLogged()
    }

    private fun checkAlreadyLogged() {
        val entryInfoModel = loginModelHolder.getLoginModel()
        router.newRootScreen(getFirstScreen(entryInfoModel))
    }

    private fun getFirstScreen(loginModel: LoginModel?): Screen {
        return if (loginModel == null) {
            Screens.LoginScreen()
        } else {
            Screens.BottomNavigationFragmentScreen()
        }
    }
}
