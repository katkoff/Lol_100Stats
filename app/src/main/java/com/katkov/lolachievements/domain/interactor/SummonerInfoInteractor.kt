package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.ChampionMasteryRepository
import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import com.katkov.lolachievements.domain.model.ChampionMasteryDto
import com.katkov.lolachievements.domain.model.SummonerModel
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoInteractor
@Inject
constructor(
//    private val summonerApiRepository: SummonerApiRepository,
    private val summonerRepository: SummonerRepository,
    private val championMasteryRepository: ChampionMasteryRepository
) {

    fun getSummonerRomDB(): Single<SummonerModel> = summonerRepository.getSummoner()

    fun getChampionsMastery(encryptedSummonerId: String): Single<List<ChampionMasteryDto>> =
        championMasteryRepository.getChampionsMastery(encryptedSummonerId)
}
