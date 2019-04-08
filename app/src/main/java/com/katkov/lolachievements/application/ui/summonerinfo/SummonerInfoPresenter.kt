package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.InjectViewState
import com.katkov.lolachievements.application.base.BasePresenter
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor
import com.katkov.lolachievements.domain.model.MasteryModel
import javax.inject.Inject

@InjectViewState
class SummonerInfoPresenter
@Inject
constructor(
    private val summonerInfoInteractor: SummonerInfoInteractor
) : BasePresenter<SummonerInfoView>() {

    override fun onFirstViewAttach() {
//        getSummonerInfo()
    }

//    private fun getSummonerInfo() {
//        viewState.setProgressEnable(true)
//        summonerInfoInteractor.getSummonerRomDb()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                viewState.fillSummonerInfo(it)
//
//                getChampionsMastery(it.encryptedId)
//            },
//                { throwable ->
//                    viewState.setProgressEnable(false)
//                    viewState.showError(Error(throwable))
//                    throwable.printStackTrace()
//                }).also { compositeDisposable.add(it) }
//    }
//
//    private fun getChampionsMastery(encryptedSummonerId: String) {
//        summonerInfoInteractor.getChampionsMastery(encryptedSummonerId)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ championsMasteryList ->
//                viewState.setProgressEnable(false)
//                viewState.fillChestCount(getChestCount(championsMasteryList))
//            },
//                { throwable ->
//                    viewState.setProgressEnable(false)
//                    viewState.showError(Error(throwable))
//                    throwable.printStackTrace()
//                }).also { compositeDisposable.add(it) }
//    }

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
