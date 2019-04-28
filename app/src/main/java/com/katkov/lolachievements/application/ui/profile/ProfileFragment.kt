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
import com.katkov.lolachievements.domain.model.LoginModel
import com.katkov.lolachievements.utils.ServerNamesHandler
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

    override fun fillInfo(loginModel: LoginModel?) {
        TextInputUtils.setText(textView_summonerName, loginModel!!.summonerName)
        TextInputUtils.setText(
            textView_summonerLevel,
            ServerNamesHandler.getNameByCode(loginModel.serverCode))
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
