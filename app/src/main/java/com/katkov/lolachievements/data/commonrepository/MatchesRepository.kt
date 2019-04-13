package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MatchesApiRepository
import com.katkov.lolachievements.data.local.repository.MatchesDbRepository
import com.katkov.lolachievements.data.mappers.MatchesMapper
import com.katkov.lolachievements.domain.model.MatchlistModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableFromAction
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

    fun load(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            matchesApiRepository.getApiMatchList(summonerModel.encryptedAccountId)
                .map { matchlistApiDto -> mapper.matchlistApiToDbModel(matchlistApiDto) }
                .flatMapCompletable { matchlistDbModel ->
                    CompletableFromAction.fromObservable(
                        matchesDbRepository.saveMatchlistDbModel(matchlistDbModel))
                }
        }

    fun getMatches(): Single<MatchlistModel> = matchesDbRepository.getMatchlistDbModel()
        .map { mapper.matchlistDbToDomainModel(it) }

    fun updateMatches(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            matchesApiRepository.getApiMatchList(summonerModel.encryptedAccountId)
                .map { mapper.matchlistApiToDbModel(it) }
                .flatMapCompletable { matchlistDbModel ->
                    matchesDbRepository.updateMatchlistDbModel(matchlistDbModel)
                }
        }

    fun removeTable(): Completable = matchesDbRepository.removeTable()
}