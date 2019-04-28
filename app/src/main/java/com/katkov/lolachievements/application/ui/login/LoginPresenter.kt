package com.katkov.lolachievements.application.ui.login

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.*
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
    private val matchReferenceInteractor: MatchReferenceInteractor,
    private val matchInteractor: MatchInteractor,
    @GlobalRouter private val router: Router
) : BasePresenter<LoginView>() {

    private var selectedNameIndex: Int = 0

    //TODO добавить валидацию заполнения полей логина и пароля
    fun onLoginButtonClicked(summonerName: String) {
        val loginModel = LoginModel(
            summonerName,
            ServerNamesHandler.getCodeByIndex(selectedNameIndex))

        loginInteractor.saveLoginModel(loginModel)

        loadAllInfoToDb()
    }

    private fun loadAllInfoToDb() {
        viewState.setProgressEnable(true)
        // Check that BD doesn't empty
        summonerInteractor.getRowsCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ rowsCount ->
                // If DB is empty, information from API to DB
                if (rowsCount == 0) {
                    summonerInteractor.loadSummoner()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            loadChampions()
                        }, { throwable ->
                            throwable.printStackTrace()
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                        }).also { compositeDisposable.add(it) }
                } else {
                    viewState.setProgressEnable(false)
                }
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun loadChampions() {
        championInteractor.loadChampion()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadMatchReferenceListToDb()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun loadMatchReferenceListToDb() {
        matchReferenceInteractor.loadMatchReferenceListToDb()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setProgressEnable(false)

                loadMatchesToDb()
                showLoadMatchesToDbProgress()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun showLoadMatchesToDbProgress() {
        viewState.setProgressDialogEnable(true)
        matchInteractor.getLoadProgressObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ progressData ->
                viewState.setProgressDialogValues(progressData.progress, progressData.maxProgress)
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressDialogEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun loadMatchesToDb() {
        matchInteractor.loadMatchListToDb()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setProgressEnable(false)

                router.replaceScreen(Screens.BottomNavigationFragmentScreen())
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.setProgressDialogEnable(false)
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
