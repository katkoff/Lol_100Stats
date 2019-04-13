package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChampionDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    private var championDao = appDataBase.ChampionDao()

    // For checking that table rows exist before starting download from API
    fun getRowsCount(): Single<Int> = championDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun saveChampionDbList(championDbList: List<ChampionDbModel>): Observable<Unit> =
        Observable.fromCallable {
            for (masteryDbModel in championDbList) {
                championDao.insert(masteryDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun getChmpionDbList(): Single<List<ChampionDbModel>> = championDao.getChampion()
        .subscribeOn(Schedulers.io())

    fun updateChampionDbList(championDbList: List<ChampionDbModel>): Completable =
        Completable.fromAction {
            for (masteryDbModel in championDbList) {
                championDao.insertOrUpdate(masteryDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun removeTable(): Completable = Completable.fromAction { championDao.removeTable() }
        .subscribeOn(Schedulers.io())
}
