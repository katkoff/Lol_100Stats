package com.katkov.lolachievements.domain.interactor

import com.katkov.lolachievements.data.cloud.repository.MatchRepository
import com.katkov.lolachievements.data.commonrepository.SummonerRepository
import javax.inject.Inject

class AchievementInteractor
@Inject
constructor(
    private val matchRepository: MatchRepository,
    private val summonerRepository: SummonerRepository
) {

    //flatMAp
//    fun getMatchList(): Single<MatchlistDto> {
//        summonerRepository.getSummonerRomDB()
//            .subscribe({
//                matchRepository.getMatchlist(it.encryptedAccountId)
//            }, {
//                it.printStackTrace()
//            })
//    }
}