package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.domain.interactor.ChampionInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInteractor
import com.katkov.lolachievements.domain.model.ChampionModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class SummonerInfoPresenter
@Inject
constructor(
    private val summonerInteractor: SummonerInteractor,
    private val championInteractor: ChampionInteractor
) : BasePresenter<SummonerInfoView>() {

    override fun onFirstViewAttach() {
        getInfo()
    }

    private fun getInfo() {
        viewState.setProgressEnable(true)
        summonerInteractor.getSummoner()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ summonerModel ->
                viewState.fillSummonerInfo(summonerModel)
                getChampionsMastery()
            }, { throwable ->
                viewState.setProgressEnable(false)
                viewState.showError(Error(throwable))
                throwable.printStackTrace()
            }).also { compositeDisposable.add(it) }
    }

    private fun getChampionsMastery() {
        championInteractor.getChampionList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ championsMasteryList ->
                viewState.setProgressEnable(false)
                viewState.fillChestCount(getChestCount(championsMasteryList))
            },
                { throwable ->
                    viewState.setProgressEnable(false)
                    viewState.showError(Error(throwable))
                    throwable.printStackTrace()
                }).also { compositeDisposable.add(it) }
    }

    private fun getChestCount(championModels: List<ChampionModel>): Int {
        var count = 0
        for (item in championModels) {
            if (item.isChestGranted) {
                count++
            }
        }
        return count
    }
}
