package com.katkov.lolachievements.application.ui.common

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseActivityAndroidX
import com.katkov.lolachievements.di.Scopes
import kotlinx.android.synthetic.main.activity_common.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class CommonActivity : BaseActivityAndroidX(), CommonView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var presenterProvider: Provider<CommonPresenter>

    @InjectPresenter
    lateinit var presenter: CommonPresenter

    @ProvidePresenter
    fun providePresenter(): CommonPresenter {
        return presenterProvider.get()
    }

    private val commonNavigator = SupportAppNavigator(this, R.id.frameLayout_commonContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        initBottomNavigationItemListeners()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(commonNavigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    private fun initBottomNavigationItemListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.achievements_menu_item -> {
                    presenter.onAchievementMenuItemClick()
                    true
                }
                R.id.profile_menu_item -> {
                    presenter.onProfileMenuItemClick()
                    true
                }
                else -> false
            }
        }
    }
}