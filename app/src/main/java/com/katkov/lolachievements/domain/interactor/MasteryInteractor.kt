package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MasteryRepository
import com.katkov.lolachievements.domain.model.MasteryModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MasteryInteractor
@Inject
constructor(
    private val masteryRepository: MasteryRepository
) {

    fun getRowsCount(): Single<Int> = masteryRepository.getRowsCount()

    fun getMasteryList(): Single<List<MasteryModel>> = masteryRepository.getMasteryList()

    fun loadMastery(): Completable = masteryRepository.load()

    fun updateMastery(): Completable = masteryRepository.updateMastery()
}