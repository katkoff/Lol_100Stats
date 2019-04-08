package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MasteryRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MasteryInteractor
@Inject
constructor(
    private val masteryRepository: MasteryRepository
){

    fun getRowsCount(): Single<Int> {
        return masteryRepository.getRowsCount()
    }

    fun loadMastery(): Completable {
        return masteryRepository.load()
    }

    fun updateMastery(): Completable {
        return masteryRepository.updateMastery()
    }
}