package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.MatchListApiRepository
import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import javax.inject.Inject

class AchievementInteractor
@Inject
constructor(
    private val matchListApiRepository: MatchListApiRepository,
    private val summonerRepository: SummonerRepository
) {

    //flatMAp
//    fun getMatchList(): Single<MatchlistDto> {
//        summonerRepository.getSummonerRomDb()
//            .subscribe({
//                matchListApiRepository.getApiMatchList(it.encryptedAccountId)
//            }, {
//                it.printStackTrace()
//            })
//    }
}