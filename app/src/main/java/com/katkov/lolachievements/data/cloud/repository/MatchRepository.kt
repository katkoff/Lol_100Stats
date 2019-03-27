package com.katkov.lolachievements.data.cloud.repository

import com.katkov.lolachievements.data.cloud.api.ApiService
import com.katkov.lolachievements.data.cloud.utils.ApiUtils
import com.katkov.lolachievements.data.mappers.MathlistApiDtoToDomainMapper
import com.katkov.lolachievements.domain.model.MatchlistDto
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MatchRepository
@Inject
constructor(
    private val apiService: ApiService,
    private val mapper: MathlistApiDtoToDomainMapper
) {
    fun getMatchlist(encryptedAccountId: String): Single<MatchlistDto> {
        return apiService.getMatchlistApiDto(encryptedAccountId, ApiUtils.API_KEY)
            .map { mapper.map(it) }
            .subscribeOn(Schedulers.io())
    }
}