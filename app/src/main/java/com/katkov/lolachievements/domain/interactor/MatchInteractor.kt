package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MatchRepository
import com.katkov.lolachievements.domain.model.LoadProgressModel
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class MatchInteractor
@Inject
constructor(
    private val matchRepository: MatchRepository
) {

    fun loadMatchListToDb(): Completable =
        matchRepository.loadMatchesToDb()

    fun getLoadProgressObservable(): Observable<LoadProgressModel> =
            matchRepository.getLoadProgressObservable()

//    fun getMatchReferenceListFromDb(): Single<List<MatchReferenceModel>> =
//        matchReferenceRepository.getMatches()
//
//    fun removeTable(): Completable = matchReferenceRepository.removeTable()
}