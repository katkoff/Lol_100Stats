package com.katkov.lolachievements.data.commonrepository

import android.util.Log
import com.katkov.lolachievements.data.cloud.model.match.MatchApiModel
import com.katkov.lolachievements.data.cloud.repository.MatchApiRepository
import com.katkov.lolachievements.data.local.repository.MatchDbRepository
import com.katkov.lolachievements.data.mappers.MatchMapper
import com.katkov.lolachievements.domain.model.LoadProgressModel
import com.katkov.lolachievements.domain.model.MatchModel
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MatchRepository
@Inject
constructor(
    private val mapper: MatchMapper,
    private val matchApiRepository: MatchApiRepository,
    private val matchDbRepository: MatchDbRepository,
    private val summonerRepository: SummonerRepository,
    private val matchReferenceRepository: MatchReferenceRepository
) {

    private var loadProgressSubject: BehaviorSubject<LoadProgressModel> = BehaviorSubject.create()

    fun getLoadProgressObservable(): Observable<LoadProgressModel> = loadProgressSubject

    fun loadMatchesToDb(): Completable {
        return getSummonerName()
            .flatMapCompletable { summonerModel ->
                getMatchReferenceList()
                    .flatMapCompletable { matchReferenceList ->
                        Completable.concat(
                            getMatchCompletableList(
                                matchReferenceList,
                                summonerModel))
                    }
            }
    }

    private fun getMatchCompletableList(
        matchReferenceList: List<MatchReferenceModel>,
        summonerModel: SummonerModel
    ): List<Completable> {
        Log.d("myLog", "== Start loading ==")
        val summonerName = summonerModel.name
        val resultList = mutableListOf<Completable>()
        var progress = 1

        matchReferenceList.forEach {
            val completable =
                matchApiRepository.getMatchApiModel(it.gameId)
                    .delay(1200, TimeUnit.MILLISECONDS)
                    .retryWhen { throwableObservable ->
                        retryGetMatchApiModel(throwableObservable)
                    }
                    .flatMapCompletable { matchApiModel ->
                        loadProgressSubject.onNext(LoadProgressModel(progress, resultList.size))
                        Log.d("myLog", "Load " + progress + " match")
                        progress += 1

                        saveMatchToDb(matchApiModel, summonerName)
                    }
            resultList.add(completable)
        }

        return resultList
    }

    private fun retryGetMatchApiModel(throwableObservable: Flowable<Throwable>): Flowable<Throwable> {
        return throwableObservable
            .flatMap { throwable ->
                //              if (shouldRetry(throwable)) {
                Log.d("myLog", "== ERROR DETECTED! == ")
                Log.d("myLog", "Localized message: " + throwable.localizedMessage)
                Flowable.just(throwable)
//              } else {
//                  Flowable.error<Throwable>(throwable)
//              }
            }
            .take(3)
            .delay(1200, TimeUnit.MILLISECONDS)
            .doOnNext { Log.d("myLog", "== Retry getting this match ==") }
    }

//    private fun shouldRetry(throwable: Throwable): Boolean {
//        return throwable is HttpException && throwable.code() == 503
//    }

    private fun saveMatchToDb(matchApiModel: MatchApiModel, summonerName: String): Completable {
        val matchDbModel = mapper.mapApiMatchToDbModel(matchApiModel, summonerName)
        return matchDbRepository.saveMatchDbModel(matchDbModel)
    }

    private fun getSummonerName(): Single<SummonerModel> =
        summonerRepository.getSummoner()

    private fun getMatchReferenceList(): Single<List<MatchReferenceModel>> =
        matchReferenceRepository.getMatches()

    fun getRowsCount(): Single<Int> = matchDbRepository.getRowsCount()

    fun getMatchListFromDb(): Single<List<MatchModel>> =
        matchDbRepository.getMatchDbList()
            .map { mapper.mapDbToDomainList(it) }

    //    fun updateChampion(): Completable = summonerRepository.getSummoner()
//        .flatMapCompletable { summonerModel ->
//            championApiRepository.getApiChampion(summonerModel.encryptedId)
//                .map { mapper.mapApiToDbList(it) }
//                .flatMapCompletable { masteryDbList ->
//                    championDbRepository.updateChampionDbList(masteryDbList)
//                }
//        }

    fun removeTable(): Completable = matchDbRepository.removeTable()
}