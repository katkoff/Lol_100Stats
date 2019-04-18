package com.katkov.lolachievements.application.ui.summonerinfo

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
import com.katkov.lolachievements.domain.model.SummonerModel
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_summoner_info.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class SummonerInfoFragment : BaseFragment(), SummonerInfoView {

    @Inject
    lateinit var presenterProvider: Provider<SummonerInfoPresenter>

    @InjectPresenter
    lateinit var presenter: SummonerInfoPresenter

    @ProvidePresenter
    internal fun providePresenter(): SummonerInfoPresenter {
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
        return inflater.inflate(R.layout.fragment_summoner_info, container, false)
    }

    override fun fillSummonerInfo(summonerModel: SummonerModel) {
        TextInputUtils.setText(textView_summonerName, summonerModel.name)
        TextInputUtils.setText(textView_summonerLevel, summonerModel.summonerLevel.toString())
    }

    override fun fillChestCount(chestCount: Int) {
        TextInputUtils.setText(textView_chestCount, chestCount.toString())
    }

    override fun setProgressEnable(isEnable: Boolean) {
        if (isEnable) {
            progressbar_summoner_info.visibility = View.VISIBLE
        } else {
            progressbar_summoner_info.visibility = View.GONE
        }
    }

    companion object {
        fun newInstance() = SummonerInfoFragment().apply { arguments = bundleOf() }
    }
}
