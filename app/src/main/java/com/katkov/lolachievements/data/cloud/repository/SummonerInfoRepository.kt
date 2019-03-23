package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.utils.ApiUtils.API_KEY
import com.katkov.lolachievements.data.mappers.SummonerDTOApiToDomainMapper
import com.katkov.lolachievements.domain.model.SummonerDTO
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SummonerInfoRepository
@Inject
constructor(
        private val apiService: ApiService,
        private val mapper: SummonerDTOApiToDomainMapper) {

    fun getSummonerDTO(summonerName: String): Single<SummonerDTO> {
        return apiService.getSummonerDTO(summonerName, API_KEY)
                .map { mapper.map(it) }
                .subscribeOn(Schedulers.io())
    }
}
