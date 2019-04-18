package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.ChampionRepository
import com.katkov.lolachievements.domain.model.ChampionModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ChampionInteractor
@Inject
constructor(
    private val championRepository: ChampionRepository
) {

    fun getRowsCount(): Single<Int> = championRepository.getRowsCount()

    fun loadChampion(): Completable = championRepository.load()

    fun getChampionList(): Single<List<ChampionModel>> = championRepository.getChampionList()

    fun updateChampion(): Completable = championRepository.updateChampion()

    fun removeTable(): Completable = championRepository.removeTable()
}