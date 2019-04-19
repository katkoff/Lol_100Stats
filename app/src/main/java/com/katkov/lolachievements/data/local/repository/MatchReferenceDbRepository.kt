package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.MatchReferenceDbModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchReferenceDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    private var matchesDao = appDataBase.matchesDao()

    // For checking that table rows exist before starting download from API
    fun getRowsCount(): Single<Int> = matchesDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun saveMatchReferenceDbList(matchReferenceDbList: List<MatchReferenceDbModel>): Completable =
        Completable.fromAction {
            for (matchReferenceDbModel in matchReferenceDbList) {
                matchesDao.insert(matchReferenceDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun getMatchReferenceDbList(): Single<List<MatchReferenceDbModel>> = matchesDao.getMatches()
        .subscribeOn(Schedulers.io())

    fun removeTable(): Completable = Completable.fromAction { matchesDao.removeTable() }
        .subscribeOn(Schedulers.io())
}