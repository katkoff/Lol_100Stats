package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import io.reactivex.Completable
import javax.inject.Inject

class MainInteractor
@Inject
constructor(
    private val summonerRepository: SummonerRepository
){

    fun loadSummoner(): Completable {
        return summonerRepository.load()
    }
}