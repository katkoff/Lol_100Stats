package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SummonerInteractor
@Inject
constructor(
    private val summonerRepository: SummonerRepository
) {

    fun getRowsCount(): Single<Int> = summonerRepository.getRowsCount()

    fun loadSummoner(): Completable = summonerRepository.load()

    fun getSummoner(): Single<SummonerModel> = summonerRepository.getSummoner()

    fun updateSummoner(): Completable = summonerRepository.updateSummoner()

    fun removeTable(): Completable = summonerRepository.removeTable()
}