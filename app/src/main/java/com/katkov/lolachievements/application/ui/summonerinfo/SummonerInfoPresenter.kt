package com.katkov.lolachievements.application.ui.summonerinfo

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.katkov.lolachievements.data.local.prefser.EntryInfoHolder
import com.katkov.lolachievements.domain.interactor.SummonerInfoInteractor
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class SummonerInfoPresenter @Inject
constructor(
        private val summonerInfoInteractor: SummonerInfoInteractor,
        private val entryInfoHolder: EntryInfoHolder) : MvpPresenter<SummonerInfoView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        getSummonerInfo()
    }

    private fun getSummonerInfo() {
        viewState.setProgressEnable(true)
        val summonerName = entryInfoHolder.getEntryInfo()!!.summonerName
        val disposable = summonerInfoInteractor.getSummonerDTO(summonerName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ summonerDTO ->
                    viewState.fillSummonerInfo(summonerDTO)

                    getChampionsMastery(summonerDTO.id)
                },
                        { throwable ->
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                            throwable.printStackTrace()
                        })
        compositeDisposable.add(disposable)
    }

    private fun getChampionsMastery(encryptedSummonerId: String) {
        val disposable = summonerInfoInteractor.getChampionsMastery(encryptedSummonerId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ championsMasteryList ->
                    viewState.setProgressEnable(false)
                    viewState.fillChestCount(getChestCount(championsMasteryList))
                },
                        { throwable ->
                            viewState.setProgressEnable(false)
                            viewState.showError(Error(throwable))
                            throwable.printStackTrace()
                        })
        compositeDisposable.add(disposable)
    }

    private fun getChestCount(masteryDTOS: List<ChampionMasteryDTO>): Int {
        var count = 0
        for (item in masteryDTOS) {
            if (item.isChestGranted) {
                count++
            }
        }
        return count
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
