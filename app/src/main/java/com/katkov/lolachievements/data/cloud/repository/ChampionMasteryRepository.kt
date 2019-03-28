package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import com.katkov.lolachievements.data.mappers.ChampionMasteryApiDtoToDomainMapper
import com.katkov.lolachievements.domain.model.ChampionMasteryDto
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChampionMasteryRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val mapper: ChampionMasteryApiDtoToDomainMapper
) {

    fun getChampionsMastery(encryptedSummonerId: String): Single<List<ChampionMasteryDto>> {
        return apiService.getChampionsMasteryApiDto(encryptedSummonerId, ApiUtils.API_KEY)
            .map { mapper.mapList(it) }
            .subscribeOn(Schedulers.io())
    }
}
