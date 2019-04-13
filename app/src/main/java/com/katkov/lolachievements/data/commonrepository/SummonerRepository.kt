package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.SummonerApiRepository
import com.katkov.lolachievements.data.local.repository.SummonerDbRepository
import com.katkov.lolachievements.data.mappers.SummonerMapper
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class SummonerRepository
@Inject
constructor(
    private val mapper: SummonerMapper,
    private val summonerApiRepository: SummonerApiRepository,
    private val summonerDbRepository: SummonerDbRepository
) {

    fun getRowsCount(): Single<Int> =
        summonerDbRepository.getRowsCount()

    fun load(): Completable = summonerApiRepository.getSummonerApiDto()
        .map { mapper.mapApiToDbModel(it) }
        .flatMapCompletable {
            Completable.fromObservable(summonerDbRepository.saveSummonerDbModel(it))
        }

    fun getSummoner(): Single<SummonerModel> = summonerDbRepository.getSummonerDbModel()
        .map { mapper.mapDbToDomainModel(it) }

    fun updateSummoner(): Completable = summonerApiRepository.getSummonerApiDto()
        .map { mapper.mapApiToDbModel(it) }
        .flatMapCompletable {
            summonerDbRepository.updateSummonerDbModel(it)
        }

    fun removeTable(): Completable = summonerDbRepository.removeTable()
}