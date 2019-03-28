package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.utils.ApiUtils.API_KEY
import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import com.katkov.lolachievements.data.mappers.SummonerApiDtoToDomainMapper
import com.katkov.lolachievements.domain.model.SummonerDto
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SummonerInfoRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val mapperDto: SummonerApiDtoToDomainMapper,
    private val loginModelHolder: LoginModelHolder
) {

    fun getSummonerDTO(): Single<SummonerDto> {
        val summonerName = loginModelHolder.getLoginModel()!!.summonerName

        return apiService.getSummonerApiDto(summonerName, API_KEY)
            .map { mapperDto.map(it) }
            .subscribeOn(Schedulers.io())
    }
}
