package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MatchRepository
import io.reactivex.Completable
import javax.inject.Inject

class MatchInteractor
@Inject
constructor(
    private val matchRepository: MatchRepository
) {

    fun loadMatchListToDb(): Completable =
        matchRepository.loadMatchesToDb()

//    fun getMatchReferenceListFromDb(): Single<List<MatchReferenceModel>> =
//        matchReferenceRepository.getMatches()
//
//    fun removeTable(): Completable = matchReferenceRepository.removeTable()
}