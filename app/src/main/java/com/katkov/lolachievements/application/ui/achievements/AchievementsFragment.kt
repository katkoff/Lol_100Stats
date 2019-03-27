package com.katkov.lolachievements.application.ui.achievements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseFragment
import com.katkov.lolachievements.application.ui.achievements.list.AchievementsRecyclerAdapter
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.domain.model.AchievementModel
import kotlinx.android.synthetic.main.fragment_achievements.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class AchievementsFragment : BaseFragment(), AchievementsView {

    @Inject
    lateinit var presenterProvider: Provider<AchievementsPresenter>

    @InjectPresenter
    lateinit var presenter: AchievementsPresenter

    @ProvidePresenter
    internal fun providePresenter(): AchievementsPresenter {
        return presenterProvider.get()
    }

    private val achievementsRecyclerAdapter = AchievementsRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.AFTER_LOGGING_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        recycler_achievements.adapter = achievementsRecyclerAdapter
        recycler_achievements.layoutManager = LinearLayoutManager(this.context)
    }

    override fun fillAchievements(achievements: List<AchievementModel>) {
        achievementsRecyclerAdapter.setData(achievements)
    }

    companion object {
        fun newInstance() = AchievementsFragment().apply { arguments = bundleOf() }
    }
}