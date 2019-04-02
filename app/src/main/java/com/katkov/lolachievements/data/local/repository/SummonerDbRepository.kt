package com.katkov.lolachievements.data.local.repository

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
    private val appDataBase: AppDataBase
) {

    fun saveSummonerDbModel(summonerDbModel: SummonerDbModel): Observable<Unit> =
        Observable.fromCallable { appDataBase.summonerDao().insert(summonerDbModel) }

    fun getSummonerDbModel(): Single<SummonerDbModel> {
        return appDataBase.summonerDao().getAll()
            .subscribeOn(Schedulers.io())
    }

    fun updateSummonerDbModel(summonerDbModel: SummonerDbModel): Completable =
        Completable.fromAction { appDataBase.summonerDao().update(summonerDbModel) }

    fun deleteSummonerDbModel(summonerDbModel: SummonerDbModel): Observable<Unit> =
        Observable.fromCallable { appDataBase.summonerDao().delete(summonerDbModel) }
}