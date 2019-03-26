package com.katkov.lolachievements.application.ui.bottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseFragment
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.annotations.AfterLoggingHolder
import com.katkov.lolachievements.di.module.AfterLoggingCiceroneModule
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class BottomNavigationFragment : BaseFragment(), BottomNavigationView {

    @Inject
    @field:AfterLoggingHolder
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var presenterProvider: Provider<BottomNavigationPresenter>

    @InjectPresenter
    lateinit var presenter: BottomNavigationPresenter

    @ProvidePresenter
    fun providePresenter(): BottomNavigationPresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this,
            Toothpick.openScopes(
                Scopes.APP_SCOPE,
                Scopes.AFTER_LOGGING_SCOPE).apply { installModules(AfterLoggingCiceroneModule()) })
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavigationItemListeners()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(
            SupportAppNavigator(
                this.activity,
                this.childFragmentManager,
                R.id.frameLayout_commonContainer))
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

    override fun closeScope() {
        super.closeScope()
        Toothpick.closeScope(Scopes.AFTER_LOGGING_SCOPE)
    }

    companion object {
        fun newInstance() = BottomNavigationFragment().apply { arguments = bundleOf() }
    }
}