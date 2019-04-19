package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.MatchDbModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    private var matchDao = appDataBase.matchDao()

    fun getRowsCount(): Single<Int> = matchDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun saveMatchDbList(matchDbModelList: List<MatchDbModel>): Completable =
        Completable.fromAction {
            for (matchDbModel in matchDbModelList) {
                matchDao.insert(matchDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun getMatchDbList(): Single<List<MatchDbModel>> = matchDao.getMatches()
        .subscribeOn(Schedulers.io())


    fun removeTable(): Completable = Completable.fromAction { matchDao.removeTable() }
        .subscribeOn(Schedulers.io())
}
