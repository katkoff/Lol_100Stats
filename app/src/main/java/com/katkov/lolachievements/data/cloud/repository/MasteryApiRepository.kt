package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.model.MasteryApiDto
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MasteryApiRepository
@Inject
constructor(
    private val apiService: ApiService
) {

    fun getApiMastery(encryptedSummonerId: String): Single<List<MasteryApiDto>> =
        apiService.getMasteryApiDto(encryptedSummonerId, ApiUtils.API_KEY)
            .subscribeOn(Schedulers.io())
}
