package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.model.match.MatchApiModel
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchApiRepository
@Inject
constructor(
    private val apiService: ApiService
) {

    fun getMatchApiModel(matchId: Long): Single<MatchApiModel> =
        apiService.getMatchApiModel(matchId, ApiUtils.API_KEY)
            .subscribeOn(Schedulers.io())
}
