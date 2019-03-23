package com.katkov.lolachievements.application.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import com.katkov.lolachievements.domain.model.EntryInfoModel
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import javax.inject.Inject

@InjectViewState
class MainPresenter
@Inject
internal constructor(
        private val router: Router,
        private val entryInfoHolder: EntryInfoHolder) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        checkAlreadyLogged()
    }

    private fun checkAlreadyLogged() {
        val entryInfoModel = entryInfoHolder.entryInfoModel
        router.newRootScreen(getFirstScreen(entryInfoModel))
    }

    private fun getFirstScreen(entryInfoModel: EntryInfoModel?): Screen {
        return if (entryInfoModel == null) {
            Screens.FirstEntryScreen()
        } else {
            Screens.CheckFirstEntryInfoScreen()
        }
    }
}
