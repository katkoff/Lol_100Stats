package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.MatchlistDbModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchesDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    private var matchesDao = appDataBase.matchesDao()

    // For checking that table rows exist before starting download from API
    fun getRowsCount(): Single<Int> = matchesDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun saveMatchlistDbModel(matchlistDbModel: MatchlistDbModel): Observable<Unit> =
        Observable.fromCallable {
            matchesDao.insert(matchlistDbModel)
        }
            .subscribeOn(Schedulers.io())

    fun getMatchlistDbModel(): Single<MatchlistDbModel> = matchesDao.getMatches()
        .subscribeOn(Schedulers.io())

    fun updateMatchlistDbModel(matchlistDbModel: MatchlistDbModel): Completable =
        Completable.fromAction {
            matchesDao.update(matchlistDbModel)
        }
            .subscribeOn(Schedulers.io())

    fun removeTable(): Completable = Completable.fromAction { matchesDao.removeTable() }
        .subscribeOn(Schedulers.io())
}