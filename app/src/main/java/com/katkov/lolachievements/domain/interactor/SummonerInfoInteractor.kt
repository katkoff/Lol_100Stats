package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.ChampionMasteryRepository
import com.katkov.lolachievements.data.cloud.repository.SummonerInfoRepository
import com.katkov.lolachievements.domain.model.ChampionMasteryDto
import com.katkov.lolachievements.domain.model.SummonerDto
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoInteractor
@Inject
constructor(
    private val summonerInfoRepository: SummonerInfoRepository,
    private val championMasteryRepository: ChampionMasteryRepository
) {

    fun getSummonerDTO(): Single<SummonerDto> = summonerInfoRepository.getSummonerDTO()

    fun getChampionsMastery(encryptedSummonerId: String): Single<List<ChampionMasteryDto>> =
        championMasteryRepository.getChampionsMastery(encryptedSummonerId)
}
