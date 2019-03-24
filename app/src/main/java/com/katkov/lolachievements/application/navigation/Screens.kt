package com.katkov.lolachievements.application.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.katkov.lolachievements.application.ui.achievements.AchievementsFragment
import com.katkov.lolachievements.application.ui.checkentryinfo.CheckEntryInfoFragment
import com.katkov.lolachievements.application.ui.common.CommonActivity
import com.katkov.lolachievements.application.ui.firstentry.FirstEntryFragment
import com.katkov.lolachievements.application.ui.summonerinfo.SummonerInfoFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class FirstEntryScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FirstEntryFragment.newInstance()
        }
    }

    class CommonActivityScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, CommonActivity::class.java)
        }
    }

    class AchievementsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return AchievementsFragment.newInstance()
        }
    }

    class CheckFirstEntryInfoScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return CheckEntryInfoFragment.newInstance()
        }
    }

    class SummonerInfoScreen : SupportAppScreen() {

        override fun getFragment(): Fragment {
            return SummonerInfoFragment.newInstance()
        }
    }
}
