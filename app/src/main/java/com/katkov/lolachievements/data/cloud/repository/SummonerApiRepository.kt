package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.model.SummonerApiDto
import com.katkov.lolachievements.data.cloud.utils.ApiUtils.API_KEY
import com.katkov.lolachievements.data.local.prefser.LoginModelHolder
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SummonerApiRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val loginModelHolder: LoginModelHolder
) {

    fun getSummonerApiDto(): Single<SummonerApiDto> {
        val summonerName = loginModelHolder.getLoginModel()!!.summonerName

        return apiService.getSummonerApiDto(summonerName, API_KEY)
            .subscribeOn(Schedulers.io())
    }
}
