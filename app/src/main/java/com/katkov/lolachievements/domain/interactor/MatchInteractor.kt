package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.commonrepository.MatchRepository
import com.katkov.lolachievements.domain.model.LoadProgressModel
import com.katkov.lolachievements.domain.model.MatchDomainModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
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

    fun getMatchListFromDb(): Single<List<MatchDomainModel>> =
        matchRepository.getMatchListFromDb()

    fun removeTable(): Completable = matchRepository.removeTable()
}