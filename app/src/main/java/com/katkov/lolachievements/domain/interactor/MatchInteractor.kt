package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.MatchRepository
import com.katkov.lolachievements.domain.model.MatchlistDto
import io.reactivex.Single
import javax.inject.Inject

class MatchInteractor
@Inject
constructor(
    private val matchRepository: MatchRepository
) {
    fun getMatchlist(encryptedAccountId: String): Single<MatchlistDto> =
        matchRepository.getMatchlist(encryptedAccountId)
}