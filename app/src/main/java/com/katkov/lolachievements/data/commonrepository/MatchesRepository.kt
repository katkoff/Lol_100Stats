package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MatchesApiRepository
import com.katkov.lolachievements.data.local.repository.MatchesDbRepository
import com.katkov.lolachievements.data.mappers.MatchesMapper
import com.katkov.lolachievements.domain.model.MatchReferenceModel
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
                .map { matchlistApiModel -> mapper.mapApiToDbList(matchlistApiModel.matches) }
                .flatMapCompletable { matchReferenceDbModel ->
                    CompletableFromAction.fromObservable(
                        matchesDbRepository.saveMatchReferenceDbList(matchReferenceDbModel))
                }
        }

    fun getMatches(): Single<List<MatchReferenceModel>> = matchesDbRepository.getMatchReferenceDbList()
        .map { mapper.mapDbToDomainList(it) }

    fun removeTable(): Completable = matchesDbRepository.removeTable()
}