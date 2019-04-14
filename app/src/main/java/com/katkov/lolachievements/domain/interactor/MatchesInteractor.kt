package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MatchesRepository
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MatchesInteractor
@Inject
constructor(
    private val matchesRepository: MatchesRepository
) {

    fun getRowsCount(): Single<Int> = matchesRepository.getRowsCount()

    fun loadMatches(): Completable = matchesRepository.load()

    fun getMatches(): Single<List<MatchReferenceModel>> = matchesRepository.getMatches()

    fun removeTable(): Completable = matchesRepository.removeTable()
}