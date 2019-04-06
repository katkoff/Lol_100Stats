package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.data.cloud.repository.MatchRepository
import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import com.katkov.lolachievements.domain.model.AchievementModel
import com.katkov.lolachievements.domain.model.MatchlistDto
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class AchievementsPresenter
@Inject
internal constructor(
    private val summonerRepository: SummonerRepository,
    private val matchRepository: MatchRepository
) : BasePresenter<AchievementsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        fillAchievements()
    }

    private fun fillAchievements() {
        getSummonerInfo()
    }

    //DB
    private fun getSummonerInfo() {
        viewState.setProgressEnable(true)
        summonerRepository.getSummoner()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getMatchlist(it.encryptedAccountId)
            }, {
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
                it.printStackTrace()
            }).also { compositeDisposable.addAll(it) }
    }

    // Api
    private fun getMatchlist(encryptedAccountId: String) {
        val disposable = matchRepository.getMatchlist(encryptedAccountId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val achievements = getMatchAchievements(it)
                viewState.fillAchievements(achievements)
                viewState.setProgressEnable(false)
            }, {
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
                it.printStackTrace()
            })
        compositeDisposable.addAll(disposable)
    }

    // TODO вынести в другой слой
    private fun getMatchAchievements(matchlistDto: MatchlistDto): MutableList<AchievementModel> {
        val achievements = mutableListOf<AchievementModel>()

        val totalGames = matchlistDto.totalGames
        val fiveMatchesProgress = if (totalGames <= 5) 5 else totalGames
        val twentyFiveMatchesProgress = if (totalGames <= 25) 25 else totalGames
        val oneHundredFiveMatchesProgress = if (totalGames <= 100) 100 else totalGames
        val fiveHundredMatchesProgress = if (totalGames <= 500) 500 else totalGames

        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Начнающий",
                "Сыграть 5 матчей",
                0,
                5,
                fiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Бывалый",
                "Сыграть 25 матчей",
                0,
                25,
                twentyFiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Ветеран",
                "Сыграть 100 матчей",
                0,
                100,
                oneHundredFiveMatchesProgress))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Верховный",
                "Сыграть 500 матчей",
                0,
                500,
                fiveHundredMatchesProgress))

        return achievements
    }
}