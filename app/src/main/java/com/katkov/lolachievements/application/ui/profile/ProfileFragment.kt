package com.katkov.lolachievements.application.ui.profile

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
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_profile.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class ProfileFragment : BaseFragment(), ProfileView {

    @Inject
    lateinit var presenterProvider: Provider<ProfilePresenter>

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

    @ProvidePresenter
    internal fun providePresenter(): ProfilePresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(
            this,
            Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.AFTER_LOGGING_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        button_logout.setOnClickListener { presenter.onLogoutButtonClicked() }
    }

    override fun fillInfo(profileUiModel: ProfileUiModel) {
        TextInputUtils.setText(textView_summonerName, profileUiModel.summonerName)
        TextInputUtils.setText(textView_summonerLevel, profileUiModel.summonerLevel.toString())

        TextInputUtils.setText(textView_totalGames, profileUiModel.totalGames.toString())
        TextInputUtils.setText(textView_firstGameCreation, profileUiModel.firstGameCreation)
        TextInputUtils.setText(textView_timeInGame, profileUiModel.totalGameDuration)
        TextInputUtils.setText(textView_wins, profileUiModel.wins.toString())
        TextInputUtils.setText(textView_winRate, profileUiModel.winRate)

        TextInputUtils.setText(textView_kills, profileUiModel.kills.toString())
        TextInputUtils.setText(textView_deaths, profileUiModel.deaths.toString())
        TextInputUtils.setText(textView_assists, profileUiModel.assists.toString())

        TextInputUtils.setText(textView_doubleKills, profileUiModel.doubleKills.toString())
        TextInputUtils.setText(textView_tripleKills, profileUiModel.tripleKills.toString())
        TextInputUtils.setText(textView_quadraKills, profileUiModel.quadraKills.toString())
        TextInputUtils.setText(textView_pentaKills, profileUiModel.pentaKills.toString())

        TextInputUtils.setText(textView_firstBloodKills, profileUiModel.firstBloodKills.toString())
        TextInputUtils.setText(
            textView_firstBloodAssists,
            profileUiModel.firstBloodAssists.toString())
        TextInputUtils.setText(textView_firstTowerKills, profileUiModel.firstTowerKills.toString())
        TextInputUtils.setText(
            textView_firstTowerAssists,
            profileUiModel.firstTowerAssists.toString())

        TextInputUtils.setText(
            textView_totalDamageTaken,
            profileUiModel.totalDamageTaken.toString())
        TextInputUtils.setText(
            textView_physicalDamageTaken,
            profileUiModel.physicalDamageTaken.toString())
        TextInputUtils.setText(
            textView_magicalDamageTaken,
            profileUiModel.magicalDamageTaken.toString())

        TextInputUtils.setText(
            textView_totalDamageDealt,
            profileUiModel.totalDamageDealt.toString())
        TextInputUtils.setText(
            textView_physicalDamageDealt,
            profileUiModel.physicalDamageDealt.toString())
        TextInputUtils.setText(
            textView_totalDamageDealtToChampions,
            profileUiModel.totalDamageDealtToChampions.toString())
        TextInputUtils.setText(
            textView_physicalDamageDealtToChampions,
            profileUiModel.physicalDamageDealtToChampions.toString())

        TextInputUtils.setText(textView_totalHeal, profileUiModel.totalHeal.toString())

        TextInputUtils.setText(textView_wardsKilled, profileUiModel.wardsKilled.toString())
        TextInputUtils.setText(textView_wardsPlaced, profileUiModel.wardsPlaced.toString())

        TextInputUtils.setText(
            textView_totalMinionsKilled,
            profileUiModel.totalMinionsKilled.toString())
        TextInputUtils.setText(
            textView_neutralMinionsKilled,
            profileUiModel.neutralMinionsKilled.toString())

        TextInputUtils.setText(textView_goldEarned, profileUiModel.goldEarned.toString())
        TextInputUtils.setText(textView_goldSpent, profileUiModel.goldSpent.toString())

        TextInputUtils.setText(
            textView_totalBaronKillsByTeam,
            profileUiModel.totalBaronKillsByTeam.toString())
        TextInputUtils.setText(
            textView_firstBaronKillsByTeam,
            profileUiModel.firstBaronKillsByTeam.toString())
        TextInputUtils.setText(
            textView_firstHeraldKillsByTeam,
            profileUiModel.firstHeraldKillsByTeam.toString())
        TextInputUtils.setText(
            textView_firstBloodKillsByTeam,
            profileUiModel.firstBloodKillsByTeam.toString())
    }

    override fun setProgressEnable(isEnable: Boolean) {
        if (isEnable) {
            progressbar_check_entry_info.visibility = View.VISIBLE
        } else {
            progressbar_check_entry_info.visibility = View.GONE
        }
    }

    companion object {
        fun newInstance() = ProfileFragment().apply { arguments = bundleOf() }
    }
}
