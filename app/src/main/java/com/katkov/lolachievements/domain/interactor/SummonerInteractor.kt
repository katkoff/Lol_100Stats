package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SummonerInteractor
@Inject
constructor(
    private val summonerRepository: SummonerRepository
){

    fun getRowsCount(): Single<Int> {
        return summonerRepository.getRowsCount()
    }

    fun loadSummoner(): Completable {
        return summonerRepository.load()
    }

    fun updateSummoner(): Completable {
        return summonerRepository.updateSummoner()
    }
}