package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.SummonerDbModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SummonerDbRepository
@Inject
constructor(
    private val appDataBase: AppDataBase //TODO Почему val серый?
) {

    private var summonerDao: SummonerDao = appDataBase.summonerDao()

    fun saveSummonerDbModel(summonerDbModel: SummonerDbModel): Observable<Unit> =
        Observable.fromCallable { summonerDao.insert(summonerDbModel) }
            .subscribeOn(Schedulers.io())

    fun getSummonerDbModel(): Single<SummonerDbModel> = summonerDao.getAll()
        .subscribeOn(Schedulers.io())

    // for checking that table rows exist when we starting app
    fun getRowsCount(): Single<Int> = summonerDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun updateSummonerDbModel(summonerDbModel: SummonerDbModel): Completable =
        Completable.fromAction { summonerDao.update(summonerDbModel) }
            .subscribeOn(Schedulers.io())

    fun deleteSummonerDbModel(summonerDbModel: SummonerDbModel): Observable<Unit> =
        Observable.fromCallable { summonerDao.delete(summonerDbModel) }
            .subscribeOn(Schedulers.io())
}