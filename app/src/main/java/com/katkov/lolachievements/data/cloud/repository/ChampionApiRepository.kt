package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.model.ChampionApiDto
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ChampionApiRepository
@Inject
constructor(
    private val apiService: ApiService
) {

    fun getApiChampion(encryptedSummonerId: String): Single<List<ChampionApiDto>> =
        apiService.getChampionApiDto(encryptedSummonerId, ApiUtils.API_KEY)
            .subscribeOn(Schedulers.io())
}
