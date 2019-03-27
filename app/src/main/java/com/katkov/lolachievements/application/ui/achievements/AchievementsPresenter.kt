package com.katkov.lolachievements.application.ui.achievements

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.domain.interactor.MatchInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor
import com.katkov.lolachievements.domain.model.AchievementModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class AchievementsPresenter
@Inject
internal constructor(
    private val matchInteractor: MatchInteractor,
    private val summonerInfoInteractor: SummonerInfoInteractor
) : MvpPresenter<AchievementsView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        //In future replace to Repository
        val achievements = mutableListOf<AchievementModel>()
        achievements.add(
            AchievementModel(
                "http://ddragon.leagueoflegends.com/cdn/9.3.1/img/spell/SummonerBarrier.png",
                "Готов к бою",
                "Прошел обучение"))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Test title 2",
                "Сыграть 5 матчей"))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Бывалый",
                "Сыграть 25 матчей"))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Ветеран",
                "Сыграть 100 матчей"))
        achievements.add(
            AchievementModel(
                "http://www.clandlan.net/foros/uploads/profile/photo-thumb-42218.png?_r=1547587404",
                "Верховный",
                "Сыграть 500 матчей"))

        viewState.fillAchievements(achievements)
    }

    private fun getSummonerInfo() {
        viewState.setProgressEnable(true)
        val disposable = summonerInfoInteractor.getSummonerDTO()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getMatchlist(it.accountId)
            }, {
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
                it.printStackTrace()
            })
        compositeDisposable.addAll(disposable)
    }

    private fun getMatchlist(encryptedAccountId: String) {
        val disposable = matchInteractor.getMatchlist(encryptedAccountId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({


            }, {
                viewState.setProgressEnable(false)
                viewState.showError(Error(it))
                it.printStackTrace()
            })
        compositeDisposable.addAll(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}