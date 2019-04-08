package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.domain.interactor.MasteryInteractor
import com.katkov.lolachievements.domain.interactor.SummonerInteractor
import com.katkov.lolachievements.domain.model.MasteryModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@InjectViewState
class SummonerInfoPresenter
@Inject
constructor(
    private val summonerInteractor: SummonerInteractor,
    private val masteryInteractor: MasteryInteractor
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
        masteryInteractor.getMasteryList()
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

    private fun getChestCount(masteryModels: List<MasteryModel>): Int {
        var count = 0
        for (item in masteryModels) {
            if (item.isChestGranted) {
                count++
            }
        }
        return count
    }
}
