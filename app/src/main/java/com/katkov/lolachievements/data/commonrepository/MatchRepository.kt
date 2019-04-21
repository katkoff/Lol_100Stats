package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MatchApiRepository
import com.katkov.lolachievements.data.local.repository.MatchDbRepository
import com.katkov.lolachievements.data.mappers.MatchMapper
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
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

    private var matchIndex: Int = 0

    //TODO проверить (падаем с ошибкой Too many requests)
    fun loadMatchesToDb(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            matchReferenceRepository.getMatches()
                .flatMapCompletable { matchReferenceList ->
                    Observable.range(0, Int.MAX_VALUE)
                        .concatMap { index ->
                            matchIndex = index
                            val matchId = matchReferenceList[index].gameId
                            matchApiRepository.getMatchApiModel(matchId)
                                .flatMapObservable { matchApiModel ->
                                    matchDbRepository.saveMatchDbModel(
                                        mapper.mapApiMatchToDbModel(
                                            matchApiModel,
                                            summonerModel.name))
                                        .andThen(Observable.just(matchApiModel))
                                }
                        }
                        .takeUntil { matchReferenceList.size == matchIndex + 1 }
                        .ignoreElements()
                }
        }

    fun getRowsCount(): Single<Int> = matchDbRepository.getRowsCount()

//
//    fun getChampionList(): Single<List<ChampionModel>> =
//        championDbRepository.getChmpionDbList()
//            .map { mapper.mapDbToDomainList(it) }
//
//    fun updateChampion(): Completable = summonerRepository.getSummoner()
//        .flatMapCompletable { summonerModel ->
//            championApiRepository.getApiChampion(summonerModel.encryptedId)
//                .map { mapper.mapApiToDbList(it) }
//                .flatMapCompletable { masteryDbList ->
//                    championDbRepository.updateChampionDbList(masteryDbList)
//                }
//        }
//
//    fun removeTable(): Completable = championDbRepository.removeTable()
}