package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChampionDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    private var championsDao = appDataBase.championDao()

    // For checking that table rows exist before starting download from API
    fun getRowsCount(): Single<Int> = championsDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    //TODO repair Observable<Unit> to completable
    fun saveChampionDbList(championDbList: List<ChampionDbModel>): Completable =
        Completable.fromAction {
            for (masteryDbModel in championDbList) {
                championsDao.insert(masteryDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun getChmpionDbList(): Single<List<ChampionDbModel>> = championsDao.getChampion()
        .subscribeOn(Schedulers.io())

    fun updateChampionDbList(championDbList: List<ChampionDbModel>): Completable =
        Completable.fromAction {
            for (masteryDbModel in championDbList) {
                championsDao.insertOrUpdate(masteryDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

    fun removeTable(): Completable = Completable.fromAction { championsDao.removeTable() }
        .subscribeOn(Schedulers.io())
}
