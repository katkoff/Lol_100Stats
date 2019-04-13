package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.ChampionApiRepository
import com.katkov.lolachievements.data.local.repository.ChampionDbRepository
import com.katkov.lolachievements.data.mappers.ChampionMapper
import com.katkov.lolachievements.domain.model.ChampionModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableFromAction
import javax.inject.Inject

class ChampionRepository
@Inject
constructor(
    private val mapper: ChampionMapper,
    private val championApiRepository: ChampionApiRepository,
    private val championDbRepository: ChampionDbRepository,
    private val summonerRepository: SummonerRepository
) {

    fun getRowsCount(): Single<Int> = championDbRepository.getRowsCount()

    fun load(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            championApiRepository.getApiChampion(summonerModel.encryptedId)
                .map { masteryApiList -> mapper.mapApiToDbList(masteryApiList) }
                .flatMapCompletable { masteryDbList ->
                    CompletableFromAction.fromObservable(
                        championDbRepository.saveChampionDbList(masteryDbList))
                }
        }

    fun getChampionList(): Single<List<ChampionModel>> = championDbRepository.getChmpionDbList()
        .map { mapper.mapDbToDomainList(it) }

    fun updateChampion(): Completable = summonerRepository.getSummoner()
        .flatMapCompletable { summonerModel ->
            championApiRepository.getApiChampion(summonerModel.encryptedId)
                .map { mapper.mapApiToDbList(it) }
                .flatMapCompletable { masteryDbList ->
                    championDbRepository.updateChampionDbList(masteryDbList)
                }
        }

    fun removeTable(): Completable = championDbRepository.removeTable()
}