package com.katkov.lolachievements.application.ui.achievements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseFragmentAndroidX
import com.katkov.lolachievements.di.Scopes
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class AchievementsFragment : BaseFragmentAndroidX(), AchievementsView {

    @Inject
    lateinit var presenterProvider: Provider<AchievementsPresenter>

    @InjectPresenter
    lateinit var presenter: AchievementsPresenter

    @ProvidePresenter
    internal fun providePresenter(): AchievementsPresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.BOTTOM_NAVIGATION_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    companion object {

        fun newInstance() = AchievementsFragment().apply { arguments = bundleOf() }
    }
}