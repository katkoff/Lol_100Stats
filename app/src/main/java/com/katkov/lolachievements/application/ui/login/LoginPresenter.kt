package com.katkov.lolachievements.application.ui.login

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.ChampionInteractor
import com.katkov.lolachievements.domain.interactor.LoginInteractor
import com.katkov.lolachievements.domain.interactor.MatchesInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInteractor
import com.katkov.lolachievements.domain.model.LoginModel
import com.katkov.lolachievements.utils.ServerNamesHandler
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LoginPresenter
@Inject
internal constructor(
    private val loginInteractor: LoginInteractor,
    private val summonerInteractor: SummonerInteractor,
    private val championInteractor: ChampionInteractor,
    private val matchesInteractor: MatchesInteractor,
    @GlobalRouter private val router: Router
) : BasePresenter<LoginView>() {

    private var selectedNameIndex: Int = 0

    fun onLoginButtonClicked(summonerName: String) {
        val loginModel = LoginModel(
            summonerName,
            ServerNamesHandler.getCodeByIndex(selectedNameIndex))

        loginInteractor.saveLoginModel(loginModel)

        viewState.setProgressEnable(true)
        loadSummonerInfo()
    }

    //TODO разбить сложные методы на простые
    //TODO изменить логику прогрессбара
    private fun loadSummonerInfo() {
        // Check that BD doesn't empty
        summonerInteractor.getRowsCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ rowsCount ->
                // DB is empty. Load Summoner from API
                if (rowsCount == 0) {
                    summonerInteractor.loadSummoner()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            loadChampions()
                            loadMatches()
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        }).also { compositeDisposable.add(it) }

                } else {
                    // Summoner exist in DB. Update it
//                    summonerInteractor.updateSummoner()
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe({
//                            loadChampions()
//                            loadMatches()
//                        }, { throwable ->
//                            throwable.printStackTrace()
//                            viewState.setProgressEnable(false)
//                            viewState.showError(Error(throwable))
//                        }).also { compositeDisposable.add(it) }
                }
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun loadChampions() {
        championInteractor.getRowsCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ rowsCount ->
                if (rowsCount == 0) {
                    championInteractor.loadChampion()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
//                                                        viewState.setProgressEnable(false)
//                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        })
                } else {
                    championInteractor.updateChampion()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
//                            viewState.setProgressEnable(false)
//                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        })
                }
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun loadMatches() {
        matchesInteractor.getRowsCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ rowsCount ->
                if (rowsCount == 0) {
                    matchesInteractor.loadMatches()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            viewState.setProgressEnable(false)
//                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        })
                } else {
                    matchesInteractor.updateMatches()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            viewState.setProgressEnable(false)
//                            router.replaceScreen(Screens.BottomNavigationFragmentScreen())
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        })
                }
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
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
