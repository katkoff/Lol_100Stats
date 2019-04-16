package com.katkov.lolachievements.data.commonrepository

import android.util.Log
import com.katkov.lolachievements.data.cloud.repository.MatchesApiRepository
import com.katkov.lolachievements.data.local.repository.MatchesDbRepository
import com.katkov.lolachievements.data.mappers.MatchesMapper
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MatchesRepository
@Inject
constructor(
    private val mapper: MatchesMapper,
    private val matchesApiRepository: MatchesApiRepository,
    private val matchesDbRepository: MatchesDbRepository,
    private val summonerRepository: SummonerRepository
) {

    fun getRowsCount(): Single<Int> = matchesDbRepository.getRowsCount()

//    fun load(): Completable = summonerRepository.getSummoner()
//        .flatMapCompletable { summonerModel ->
//            var beginIndex = 0
//            var endIndex = 99
//            var matchesCount = 0
//
//            matchesApiRepository.getApiMatchList(
//                summonerModel.encryptedAccountId, beginIndex, endIndex)
//                .flatMapCompletable { matchlstApiModel ->
//                    Completable.fromAction {
//                        matchesCount += matchlstApiModel.matches.size
//
//                        matchesDbRepository.saveMatchReferenceDbList(
//                            mapper.mapApiToDbList(matchlstApiModel.matches))
//
//                        while (matchesCount <= endIndex) {
//                            beginIndex = endIndex + 1
//                            endIndex += 100
//
//                            matchesApiRepository.getApiMatchList(
//                                summonerModel.encryptedAccountId, beginIndex, endIndex)
//                                .flatMapCompletable {
//                                    // на заходит сюда
//                                    matchesCount += matchlstApiModel.matches.size
//
//                                    matchesDbRepository.saveMatchReferenceDbList(
//                                        mapper.mapApiToDbList(matchlstApiModel.matches))
//                                }
//                        }
//                    }
//                }
//        }

    //TODO переделать на generate
    fun load(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            Observable.interval(500, TimeUnit.MILLISECONDS)
                .map { digit -> Pair(digit * 100, digit * 100 + 99) }
                .concatMap { range ->
                    var beginIndex = range.first.toInt()
                    var endIndex = range.second.toInt()

                    matchesApiRepository.getApiMatchList(
                        summonerModel.encryptedAccountId, beginIndex, endIndex)
                        .flatMapObservable { matchListApiModel ->
                            Log.d("Matches", matchListApiModel.matches.size.toString())
                            matchesDbRepository.saveMatchReferenceDbList(
                                mapper.mapApiToDbList(matchListApiModel.matches))
                                .andThen(Observable.just(matchListApiModel))
                        }
                }
                .takeUntil { matchListApiModel -> matchListApiModel.matches.size < 99 }
                .ignoreElements()
        }


    fun getMatches(): Single<List<MatchReferenceModel>> =
        matchesDbRepository.getMatchReferenceDbList()
            .map { mapper.mapDbToDomainList(it) }

    fun removeTable(): Completable = matchesDbRepository.removeTable()
}