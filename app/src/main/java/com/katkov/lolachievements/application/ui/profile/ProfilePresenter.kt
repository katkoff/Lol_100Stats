package com.katkov.lolachievements.application.ui.profile

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.application.navigation.Screens
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.annotations.AfterLoggingRouter
import com.katkov.lolachievements.di.annotations.GlobalRouter
import com.katkov.lolachievements.domain.interactor.*
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class ProfilePresenter
@Inject
constructor(
    @GlobalRouter private val globalRouter: Router,
    @AfterLoggingRouter private val bottomNavigationRouter: Router,
    private val loginInteractor: LoginInteractor,
    private val summonerInteractor: SummonerInteractor,
    private val championInteractor: ChampionInteractor,
    private val matchReferenceInteractor: MatchReferenceInteractor,
    private val matchInteractor: MatchInteractor,
    private val profileMapper: ProfileMapper
) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        createUiModel()
    }

    /**
     * CREATE UI MODEL
     */
    private fun createUiModel() {
        // getSummonerInfoFromUiModel
        viewState.setProgressEnable(true)
        summonerInteractor.getSummoner()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getMatchesInfoFromUiModel(it.name, it.summonerLevel)
            }, {
                it.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
            }).also { compositeDisposable.add(it) }
    }

    private fun getMatchesInfoFromUiModel(name: String, level: Long) {
        matchInteractor.getMatchListFromDb()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ allMatches ->
                viewState.setProgressEnable(false)

                val profileUiModel = ProfileUiModel(
                    summonerName = name,
                    summonerLevel = level,

                    totalGames = allMatches.size,
                    totalGameDuration = profileMapper.mapTotalGameDuration(allMatches),
                    wins = profileMapper.mapWins(allMatches),

                    kills = profileMapper.mapKills(allMatches),
                    deaths = profileMapper.mapDeath(allMatches),
                    assists = profileMapper.mapAssists(allMatches),

                    doubleKills = profileMapper.mapDoubleKills(allMatches),
                    tripleKills = profileMapper.mapTripleKills(allMatches),
                    quadraKills = profileMapper.mapQuadraKills(allMatches),
                    pentaKills = profileMapper.mapPentaKills(allMatches),

                    firstBloodKills = profileMapper.mapFirstBloodKills(allMatches),
                    firstBloodAssists = profileMapper.mapFirstBloodAssists(allMatches),

                    firstTowerKills = profileMapper.mapFirstTowerKills(allMatches),
                    firstTowerAssists = profileMapper.mapFirstTowerAssists(allMatches),

                    totalDamageTaken = profileMapper.mapTotalDamageTaken(allMatches),
                    physicalDamageTaken = profileMapper.mapPhysicalDamageTaken(allMatches),
                    magicalDamageTaken = profileMapper.mapMagicalDamageTaken(allMatches),

                    totalDamageDealt = profileMapper.mapTotalDamageDealt(allMatches),
                    physicalDamageDealt = profileMapper.mapPhysicalDamageDealt(allMatches),
                    totalDamageDealtToChampions = profileMapper.mapTotalDamageDealtToChampions(
                        allMatches),
                    physicalDamageDealtToChampions = profileMapper.mapPhysicalDamageDealtToChampions(
                        allMatches),

                    totalHeal = profileMapper.mapTotalHeal(allMatches),

                    wardsKilled = profileMapper.mapWardsKilled(allMatches),
                    wardsPlaced = profileMapper.mapWardsPlaced(allMatches),

                    totalMinionsKilled = profileMapper.mapTotalMinionsKilled(allMatches),
                    neutralMinionsKilled = profileMapper.mapNeutralMinionsKilled(allMatches),

                    goldEarned = profileMapper.mapGoldEarned(allMatches),
                    goldSpent = profileMapper.mapGoldSpent(allMatches),

                    firstHeraldKillsByTeam = profileMapper.mapFirstHeraldKillsByTeam(allMatches),
                    firstBaronKillsByTeam = profileMapper.mapFirstBaronKillsByTeam(allMatches),
                    totalBaronKillsByTeam = profileMapper.mapTotalBaronKillsByTeam(allMatches),
                    firstBloodKillsByTeam = profileMapper.mapFirstBloodKillsByTeam(allMatches)
                )

                viewState.fillInfo(profileUiModel)
            }, {
                it.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
            }).also { compositeDisposable.add(it) }
    }


    /**
     * LOGOUT and REMOVE DB
     */
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
                removeChampionDbTable()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun removeChampionDbTable() {
        championInteractor.removeTable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                removeMatchReferenceDbTable()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun removeMatchReferenceDbTable() {
        matchReferenceInteractor.removeTable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                removeMatchDbTable()
            }, { throwable ->
                throwable.printStackTrace()
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
            }).also { compositeDisposable.add(it) }
    }

    private fun removeMatchDbTable() {
        matchInteractor.removeTable()
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
}
