package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.model.MatchlistApiModel
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchesApiRepository
@Inject
constructor(
    private val apiService: ApiService
) {
    fun getApiMatchList(
        encryptedAccountId: String,
        beginIndex: Int,
        endIndex: Int
    ): Single<MatchlistApiModel> =
        apiService.getMatchListApiDto(encryptedAccountId, ApiUtils.API_KEY, beginIndex, endIndex)
            .subscribeOn(Schedulers.io())
}