package com.katkov.lolachievements.application.ui.firstentry

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.domain.model.EntryInfoModel
import com.katkov.lolachievements.domain.usecase.LoginUseCase
import com.katkov.lolachievements.utils.ServerNamesHandler
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class FirstEntryPresenter
@Inject
internal constructor(
        private val loginUseCase: LoginUseCase,
        private val router: Router) : MvpPresenter<FirstEntryView>() {

    private var selectedNameIndex: Int = 0

    fun onLoginButtonClicked(summonerName: String) {
        val entryInfoModel = EntryInfoModel(
                summonerName,
                ServerNamesHandler.getCodeByIndex(selectedNameIndex))

        loginUseCase.saveEntryInfo(entryInfoModel)
        router.navigateTo(Screens.CheckFirstEntryInfoScreen())
    }

    fun onServerNameClicked() {
        viewState.showServerChoiceDialog()
    }

    fun onServerNameSelected(selectedIndex: Int) {
        this.selectedNameIndex = selectedIndex
        val selectedServerName = ServerNamesHandler.getNameByIndex(selectedIndex)
        viewState.showSelectedName(selectedServerName)
    }
}
