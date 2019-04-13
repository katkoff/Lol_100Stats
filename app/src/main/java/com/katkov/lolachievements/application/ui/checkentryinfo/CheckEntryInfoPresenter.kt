package com.katkov.lolachievements.application.ui.checkentryinfo

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.annotations.AfterLoggingRouter
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.ChampionInteractor
import com.katkov.lolachievements.domain.interactor.LoginInteractor
import com.katkov.lolachievements.domain.interactor.MatchesInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class CheckEntryInfoPresenter
@Inject
constructor(
    @GlobalRouter private val globalRouter: Router,
    @AfterLoggingRouter private val bottomNavigationRouter: Router,
    private val loginInteractor: LoginInteractor,
    private val summonerInteractor: SummonerInteractor,
    private val championInteractor: ChampionInteractor,
    private val matchesInteractor: MatchesInteractor
) : BasePresenter<CheckEntryInfoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.fillInfo(loginInteractor.getLoginModel())
    }

    fun onLogoutButtonClicked() {
        loginInteractor.removeLoginModel()

        removeAllDbTables()

        Toothpick.closeScope(Scopes.AFTER_LOGGING_SCOPE)
    }

    private fun removeAllDbTables() {
        // Remove Summoner DB Table
        viewState.setProgressEnable(true)
        summonerInteractor.removeTable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                removeChampionDBTable()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun removeChampionDBTable() {
        championInteractor.removeTable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                removeMatchesDBTable()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun removeMatchesDBTable() {
        matchesInteractor.removeTable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setProgressEnable(false)
                globalRouter.replaceScreen(Screens.LoginScreen())
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    fun onSummonerInfoButtonClicked() =
        bottomNavigationRouter.replaceScreen(Screens.SummonerInfoScreen())
}
