package com.katkov.lolachievements.application.ui.bottomnavigation

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.annotations.AfterLoggingRouter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BottomNavigationPresenter
@Inject
internal constructor(
    @AfterLoggingRouter private val router: Router
) : BasePresenter<BottomNavigationView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.AchievementsScreen())
    }

    fun onAchievementMenuItemClick() = router.replaceScreen(Screens.AchievementsScreen())

    fun onProfileMenuItemClick() = router.replaceScreen(Screens.ProfileScreen())
}