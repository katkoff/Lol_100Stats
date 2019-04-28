package com.katkov.lolachievements.application.ui.login

import android.app.AlertDialog
import android.app.ProgressDialog
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
import com.katkov.lolachievements.utils.ServerNamesHandler
import com.katkov.lolachievements.utils.TextInputUtils
import kotlinx.android.synthetic.main.fragment_login.*
import toothpick.Toothpick
import javax.inject.Inject
import javax.inject.Provider

class LoginFragment : BaseFragment(), LoginView {

    lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var presenterProvider: Provider<LoginPresenter>

    @InjectPresenter
    lateinit var presenter: LoginPresenter

    @ProvidePresenter
    internal fun providePresenter(): LoginPresenter {
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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initProgressDialog()
    }

    private fun initListeners() {
        inputEditText_serverName.setOnClickListener { presenter.onServerNameClicked() }
        button_login.setOnClickListener {
            val summonerName = TextInputUtils.getText(inputLayout_summonerName)
            presenter.onLoginButtonClicked(summonerName)
        }
    }

    override fun showServerChoiceDialog() {
        val serverNames = ServerNamesHandler.serverNames
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setTitle(getString(R.string.login_screen_choose_server_dialog_title))
            .setItems(serverNames) { _, selectedIndex ->
                presenter.onServerNameSelected(
                    selectedIndex)
            }
            .create()
            .show()
    }

    override fun showSelectedName(selectedName: String) {
        TextInputUtils.setText(inputLayout_serverName, selectedName)
    }

    override fun setProgressEnable(isEnable: Boolean) {
        if (isEnable) {
            progressbar_login.visibility = View.VISIBLE
        } else {
            progressbar_login.visibility = View.GONE
        }
    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(context)
        progressDialog.setTitle(resources.getString(R.string.login_progress_dialog_title))
        progressDialog.setMessage(resources.getString(R.string.login_progress_dialog_message))
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    }

    override fun setProgressDialogValues(progress: Int, progressMax: Int) {
        progressDialog.progress = progress
        progressDialog.max = progressMax

        if (progressDialog.progress == progressDialog.max) progressDialog.dismiss()
    }

    override fun setProgressDialogEnable(isEnable: Boolean) {
        if (isEnable) {
            progressDialog.show()
        } else {
            progressDialog.dismiss()
        }
    }

    companion object {
        fun newInstance() = LoginFragment().apply { arguments = bundleOf() }
    }
}
