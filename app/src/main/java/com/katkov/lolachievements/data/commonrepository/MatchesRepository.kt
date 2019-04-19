package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MatchesApiRepository
import com.katkov.lolachievements.data.local.repository.MatchesDbRepository
import com.katkov.lolachievements.data.mappers.MatchesMapper
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
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

    //TODO переделать на generate
    fun load(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            Observable.range(0, Int.MAX_VALUE)
                .map { digit -> Pair(digit * 100, digit * 100 + 99) }
                .concatMap { (beginIndex, endIndex) ->
                    matchesApiRepository.getApiMatchList(
                        summonerModel.encryptedAccountId, beginIndex, endIndex)
                        .flatMapObservable { matchListApiModel ->
                            matchesDbRepository.saveMatchReferenceDbList(
                                mapper.mapApiToDbList(matchListApiModel.matches))
                                .andThen(Observable.just(matchListApiModel))
                        }
                }
                .takeUntil { matchListApiModel -> matchListApiModel.matches.size < 100 }
                .ignoreElements()
        }

    fun getMatches(): Single<List<MatchReferenceModel>> =
        matchesDbRepository.getMatchReferenceDbList()
            .map { mapper.mapDbToDomainList(it) }

    fun removeTable(): Completable = matchesDbRepository.removeTable()
}