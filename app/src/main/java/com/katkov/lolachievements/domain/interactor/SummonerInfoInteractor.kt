package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.MasteryApiRepository
import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import com.katkov.lolachievements.data.mappers.MasteryMapper
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoInteractor
@Inject
constructor(
    private val summonerRepository: SummonerRepository,
    private val masteryApiRepository: MasteryApiRepository,
    private val masteryMapper: MasteryMapper
) {

    fun getSummonerRomDb(): Single<SummonerModel> = summonerRepository.getSummoner()

//    fun getChampionsMastery(encryptedSummonerId: String): Single<List<MasteryModel>> =
//        masteryApiRepository.getApiMastery(encryptedSummonerId)
}
