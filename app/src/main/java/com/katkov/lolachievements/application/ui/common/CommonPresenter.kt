package com.katkov.lolachievements.application.ui.common

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CommonPresenter
@Inject
internal constructor(private val router: Router) : MvpPresenter<CommonView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.navigateTo(Screens.AchievementsScreen())
    }

    fun onAchievementMenuItemClick() {
        router.navigateTo(Screens.AchievementsScreen())
    }

    fun onProfileMenuItemClick() {
        router.navigateTo(Screens.CheckFirstEntryInfoScreen())
    }
}