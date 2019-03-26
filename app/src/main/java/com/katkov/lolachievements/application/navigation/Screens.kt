package com.katkov.lolachievements.application.navigation

import com.katkov.lolachievements.application.ui.achievements.AchievementsFragment
import com.katkov.lolachievements.application.ui.bottomnavigation.BottomNavigationFragment
import com.katkov.lolachievements.application.ui.checkentryinfo.CheckEntryInfoFragment
import com.katkov.lolachievements.application.ui.login.LoginFragment
import com.katkov.lolachievements.application.ui.summonerinfo.SummonerInfoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class LoginScreen : SupportAppScreen() {
        override fun getFragment() = LoginFragment.newInstance()
    }

    class BottomNavigationFragmentScreen : SupportAppScreen() {
        override fun getFragment() = BottomNavigationFragment.newInstance()
    }

    class AchievementsScreen : SupportAppScreen() {
        override fun getFragment() = AchievementsFragment.newInstance()
    }

    class CheckFirstEntryInfoScreen : SupportAppScreen() {
        override fun getFragment() = CheckEntryInfoFragment.newInstance()
    }

    class SummonerInfoScreen : SupportAppScreen() {
        override fun getFragment() = SummonerInfoFragment.newInstance()
    }
}
