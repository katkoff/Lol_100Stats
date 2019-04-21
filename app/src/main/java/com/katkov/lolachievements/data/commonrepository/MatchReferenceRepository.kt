package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MatchReferenceApiRepository
import com.katkov.lolachievements.data.local.repository.MatchReferenceDbRepository
import com.katkov.lolachievements.data.mappers.MatchReferenceMapper
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class MatchReferenceRepository
@Inject
constructor(
    private val mapper: MatchReferenceMapper,
    private val matchReferenceApiRepository: MatchReferenceApiRepository,
    private val matchReferenceDbRepository: MatchReferenceDbRepository,
    private val summonerRepository: SummonerRepository
) {

    fun getRowsCount(): Single<Int> = matchReferenceDbRepository.getRowsCount()

    //TODO неправильно считает кол-во матчей. кажется, 2000 максимум...
    fun loadMatchReferenceListToDb(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            Observable.range(0, Int.MAX_VALUE)
                .map { digit -> Pair(digit * 100, digit * 100 + 99) }
                .concatMap { (beginIndex, endIndex) ->
                    matchReferenceApiRepository.getApiMatchList(
                        summonerModel.encryptedAccountId, beginIndex, endIndex)
                        .flatMapObservable { matchListApiModel ->
                            matchReferenceDbRepository.saveMatchReferenceDbList(
                                mapper.mapApiToDbList(matchListApiModel.matches))
                                .andThen(Observable.just(matchListApiModel))
                        }
                }
                .takeUntil { matchListApiModel -> matchListApiModel.matches.size < 99 }
                .ignoreElements()
        }

    fun getMatches(): Single<List<MatchReferenceModel>> =
        matchReferenceDbRepository.getMatchReferenceDbList()
            .map { mapper.mapDbToDomainList(it) }

    fun removeTable(): Completable = matchReferenceDbRepository.removeTable()
}