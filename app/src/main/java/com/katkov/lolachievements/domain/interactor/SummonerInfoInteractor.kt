package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.ChampionMasteryRepository
import com.katkov.lolachievements.data.cloud.repository.SummonerInfoRepository
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO
import com.katkov.lolachievements.domain.model.SummonerDTO
import io.reactivex.Single
import javax.inject.Inject

class SummonerInfoInteractor
@Inject
constructor(
        private val summonerInfoRepository: SummonerInfoRepository,
        private val championMasteryRepository: ChampionMasteryRepository) {

    fun getSummonerDTO(name: String): Single<SummonerDTO> {
        return summonerInfoRepository.getSummonerDTO(name)
    }

    fun getChampionsMastery(encryptedSummonerId: String): Single<List<ChampionMasteryDTO>> {
        return championMasteryRepository.getChampionsMastery(encryptedSummonerId)
    }
}
