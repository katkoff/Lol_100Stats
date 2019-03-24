package com.katkov.lolachievements.application.ui.checkentryinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.OnClick
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.katkov.lolachievements.R
import com.katkov.lolachievements.application.base.BaseFragmentAndroidX
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.domain.model.EntryInfoModel
import com.katkov.lolachievements.utils.ServerNamesHandler
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_check_entry_info.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class CheckEntryInfoFragment : BaseFragmentAndroidX(), CheckEntryInfoView {

    @Inject
    lateinit var presenterProvider: Provider<CheckEntryInfoPresenter>

    @InjectPresenter
    lateinit var presenter: CheckEntryInfoPresenter

    @ProvidePresenter
    internal fun providePresenter(): CheckEntryInfoPresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_check_entry_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }

    override fun fillInfo(entryInfoModel: EntryInfoModel?) {
        TextInputUtils.setText(textView_summonerName, entryInfoModel!!.summonerName)
        TextInputUtils.setText(textView_serverName, ServerNamesHandler.getNameByCode(entryInfoModel.serverCode))
    }

    @OnClick(R.id.button_logout)
    internal fun logoutButtonClicked() {
        presenter.onLogoutButtonClicked()
    }

    @OnClick(R.id.button_summonerInfo)
    internal fun onSummonerInfoButtonClick() {
        presenter.onSummonerInfoButtonClicked()
    }

    companion object {

        fun newInstance(): CheckEntryInfoFragment {
            val args = Bundle()
            val fragment = CheckEntryInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
