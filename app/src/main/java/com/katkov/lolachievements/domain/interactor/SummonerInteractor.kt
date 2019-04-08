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

    fun getSummoner(): Single<SummonerModel> = summonerRepository.getSummoner()

    fun loadSummoner(): Completable = summonerRepository.load()

    fun updateSummoner(): Completable = summonerRepository.updateSummoner()
}