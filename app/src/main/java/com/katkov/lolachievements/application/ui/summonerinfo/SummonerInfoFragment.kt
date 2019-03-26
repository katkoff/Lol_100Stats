package com.katkov.lolachievements.application.ui.summonerinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import butterknife.ButterKnife
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseFragmentAndroidX
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.domain.model.SummonerDTO
import com.katkov.lolachievements.utils.CommonStringUtils
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_summoner_info.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class SummonerInfoFragment : BaseFragmentAndroidX(), SummonerInfoView {

    @Inject
    lateinit var presenterProvider: Provider<SummonerInfoPresenter>

    @InjectPresenter
    lateinit var presenter: SummonerInfoPresenter

    @ProvidePresenter
    internal fun providePresenter(): SummonerInfoPresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.BOTTOM_NAVIGATION_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summoner_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }

    override fun fillSummonerInfo(summonerDTO: SummonerDTO) {
        if (summonerDTO.summonerName != null) {
            TextInputUtils.setText(textView_summonerName, summonerDTO.summonerName)
        } else {
            TextInputUtils.setText(textView_summonerName, CommonStringUtils.UNKNOWN_VALUE)
        }
        TextInputUtils.setText(textView_summonerLevel, summonerDTO.summonerLevel.toString())
    }

    override fun fillChestCount(chestCount: Int) {
        TextInputUtils.setText(textView_chestCount, chestCount.toString())
    }

    override fun setProgressEnable(isEnable: Boolean) {
        if (isEnable) {
            progressbar.visibility = View.VISIBLE
        } else {
            progressbar.visibility = View.GONE
        }
    }

    companion object {

        fun newInstance() = SummonerInfoFragment().apply { arguments = bundleOf() }
    }
}
