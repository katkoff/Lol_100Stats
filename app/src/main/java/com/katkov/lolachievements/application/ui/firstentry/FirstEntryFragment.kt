package com.katkov.lolachievements.application.ui.firstentry

import android.app.AlertDialog
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
import com.katkov.lolachievements.utils.ServerNamesHandler
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_first_entry.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class FirstEntryFragment : BaseFragmentAndroidX(), FirstEntryView {

    @Inject
    lateinit var presenterProvider: Provider<FirstEntryPresenter>

    @InjectPresenter
    lateinit var presenter: FirstEntryPresenter

    @ProvidePresenter
    internal fun providePresenter(): FirstEntryPresenter {
        return presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE))
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
    }

    @OnClick(R.id.inputEditText_serverName)
    internal fun serverNameButtonClick() {
        presenter.onServerNameClicked()
    }

    override fun showServerChoiceDialog() {
        val serverNames = ServerNamesHandler.getServerNames()
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle(getString(R.string.first_entry_choose_server_dialog_title))
                .setItems(serverNames) { _, selectedIndex -> presenter.onServerNameSelected(selectedIndex) }
                .create()
                .show()
    }

    override fun showSelectedName(selectedName: String) {
        TextInputUtils.setText(inputLayout_serverName, selectedName)
    }

    @OnClick(R.id.button_login)
    internal fun loginButtonClick() {
        val summonerName = TextInputUtils.getText(inputLayout_serverName)
        presenter.onLoginButtonClicked(summonerName)
    }

    companion object {

        fun newInstance(): FirstEntryFragment {
            val args = Bundle()
            val fragment = FirstEntryFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
