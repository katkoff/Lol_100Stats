package com.katkov.lolachievements.application.ui.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.LoginInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInteractor
import com.katkov.lolachievements.domain.model.LoginModel
import com.katkov.lolachievements.utils.ServerNamesHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LoginPresenter
@Inject
internal constructor(
    private val loginInteractor: LoginInteractor,
    private val summonerInteractor: SummonerInteractor,
    @GlobalRouter private val router: Router
) : MvpPresenter<LoginView>() {

    private val compositeDisposable = CompositeDisposable()
    private var selectedNameIndex: Int = 0

    fun onLoginButtonClicked(summonerName: String) {
        val loginModel = LoginModel(
            summonerName,
            ServerNamesHandler.getCodeByIndex(selectedNameIndex))

        loginInteractor.saveLoginModel(loginModel)

        // try to get Summoner from DB
        summonerInteractor.getRowsCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it > 0) {
                    summonerInteractor.updateSummoner()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, {
                            viewState.showError(Error(it)) //TODO почему почеркивает?
                        }).also { compositeDisposable.add(it) }
                } else {
                    summonerInteractor.loadSummoner()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, {
                            it.printStackTrace()
                            viewState.showError(Error(it))
                        }).also { compositeDisposable.add(it) }
                }
            }, {
                it.printStackTrace()
                viewState.showError(Error(it))
            }).also { compositeDisposable.add(it) }
    }

    fun onServerNameClicked() {
        viewState.showServerChoiceDialog()
    }

    fun onServerNameSelected(selectedIndex: Int) {
        this.selectedNameIndex = selectedIndex
        val selectedServerName = ServerNamesHandler.getNameByIndex(selectedIndex)
        viewState.showSelectedName(selectedServerName)
    }
}
