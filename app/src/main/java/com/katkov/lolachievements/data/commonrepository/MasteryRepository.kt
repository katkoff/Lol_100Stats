package com.katkov.lolachievements.data.commonrepository

import com.katkov.lolachievements.data.cloud.repository.MasteryApiRepository
import com.katkov.lolachievements.data.local.repository.MasteryDbRepository
import com.katkov.lolachievements.data.mappers.MasteryMapper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.internal.operators.completable.CompletableFromAction
import javax.inject.Inject

class MasteryRepository
@Inject
constructor(
    private val mapper: MasteryMapper,
    private val masteryApiRepository: MasteryApiRepository,
    private val masteryDbRepository: MasteryDbRepository,
    private val summonerRepository: SummonerRepository
) {

    fun load(): Completable {
        return summonerRepository.getSummoner()
            .flatMapCompletable { summonerModel ->
                masteryApiRepository.getApiMastery(summonerModel.encryptedId)
                    .map { masteryApiList -> mapper.mapApiToDbList(masteryApiList) }
                    .flatMapCompletable { masteryDbList ->
                        CompletableFromAction.fromObservable(
                            masteryDbRepository.saveMasteryDbList(masteryDbList))
                    }
            }
    }

    fun getRowsCount(): Single<Int> = masteryDbRepository.getRowsCount()

    //    fun getMastery(): Single<MasteryModel> {
//        return summonerDbRepository.getSummonerDbModel()
//            .map { mapper.mapDbToDomainModel(it) }
//    }
//
    fun updateMastery(): Completable {
        return summonerRepository.getSummoner()
            .flatMapCompletable { summonerModel ->
                masteryApiRepository.getApiMastery(summonerModel.encryptedId)
                    .map { mapper.mapApiToDbList(it) }
                    .flatMapCompletable { masteryDbList ->
                        masteryDbRepository.updateMasteryDbModel(masteryDbList)
                    }
            }
    }
}