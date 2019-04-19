package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MatchReferenceRepository
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MatchReferenceInteractor
@Inject
constructor(
    private val matchReferenceRepository: MatchReferenceRepository
) {

    fun getRowsCount(): Single<Int> = matchReferenceRepository.getRowsCount()

    fun loadMatchReferenceListToDb(): Completable =
        matchReferenceRepository.loadMatchReferenceListToDb()

    fun getMatchReferenceListFromDb(): Single<List<MatchReferenceModel>> =
        matchReferenceRepository.getMatches()

    fun removeTable(): Completable = matchReferenceRepository.removeTable()
}