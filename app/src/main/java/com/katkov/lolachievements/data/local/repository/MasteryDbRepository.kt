package com.katkov.lolachievements.data.local.repository

import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.data.local.model.MasteryDbModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MasteryDbRepository
@Inject
constructor(appDataBase: AppDataBase) {

    //TODO переделать под сохранение списка в бд
    private var masteryDao = appDataBase.masteryDao()

    // For checking that table rows exist before starting download from API
    fun getRowsCount(): Single<Int> = masteryDao.getRowsCount()
        .subscribeOn(Schedulers.io())

    fun saveMasteryDbList(masteryDbList: List<MasteryDbModel>): Observable<Unit> =
        Observable.fromCallable {
            for (masteryDbModel in masteryDbList) {
                masteryDao.insert(masteryDbModel)
            }
        }
            .subscribeOn(Schedulers.io())

//    fun getMasteryDbModel(): Single<MasteryDbModel> = masteryDao.getMastery()
//        .subscribeOn(Schedulers.io())
//
//    fun updateMasteryDbModel(summonerDbModel: SummonerDbModel): Completable =
//        Completable.fromAction { summonerDao.update(summonerDbModel) }
//            .subscribeOn(Schedulers.io())
}