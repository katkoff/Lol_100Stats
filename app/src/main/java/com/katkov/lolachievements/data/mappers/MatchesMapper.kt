package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.MatchReferenceApiModel
import com.katkov.lolachievements.data.cloud.model.MatchlistApiModel
import com.katkov.lolachievements.data.local.model.MatchlistDbModel
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import com.katkov.lolachievements.domain.model.MatchlistModel
import javax.inject.Inject

class MatchesMapper
@Inject
constructor() {

    /**
     * API to DB
     */
    fun matchlistApiToDbModel(matchlistApiModel: MatchlistApiModel): MatchlistDbModel =
        MatchlistDbModel(
            matches = matchesApiToDomain(matchlistApiModel.matches),
            totalGames = matchlistApiModel.totalGames,
            startIndex = matchlistApiModel.startIndex,
            endIndex = matchlistApiModel.endIndex
        )

    private fun matchesApiToDomain(matchReferenceApiList: List<MatchReferenceApiModel>): List<MatchReferenceModel> {
        val resultList = mutableListOf<MatchReferenceModel>()
        for (item in matchReferenceApiList) {
            resultList.add(matchReferenceApiToDomainModel(item))
        }
        return resultList
    }

    private fun matchReferenceApiToDomainModel(matchReferenceApiModel: MatchReferenceApiModel): MatchReferenceModel =
        MatchReferenceModel(
            lane = matchReferenceApiModel.lane,
            gameId = matchReferenceApiModel.gameId,
            champion = matchReferenceApiModel.champion,
            platformId = matchReferenceApiModel.platformId,
            season = matchReferenceApiModel.season,
            queue = matchReferenceApiModel.queue,
            role = matchReferenceApiModel.role,
            timestamp = matchReferenceApiModel.timestamp
        )

    /**
     * DB to Domain
     */
    fun matchlistDbToDomainModel(matchlistDbModel: MatchlistDbModel): MatchlistModel =
        MatchlistModel(
            matches = matchlistDbModel.matches,
            totalGames = matchlistDbModel.totalGames,
            startIndex = matchlistDbModel.startIndex,
            endIndex = matchlistDbModel.endIndex
        )

//    private fun matchesDbToDomain(matchReferenceDbList: List<MatchReferenceDbModel>): List<MatchReferenceModel> {
//        val resultList = mutableListOf<MatchReferenceModel>()
//        for (item in matchReferenceDbList) {
//            resultList.add(matchReferenceDbToDomainModel(item))
//        }
//        return resultList
//    }
//
//    private fun matchReferenceDbToDomainModel(matchReferenceDbModel: MatchReferenceDbModel): MatchReferenceModel =
//        MatchReferenceModel(
//            lane = matchReferenceDbModel.lane,
//            gameId = matchReferenceDbModel.gameId,
//            champion = matchReferenceDbModel.champion,
//            platformId = matchReferenceDbModel.platformId,
//            season = matchReferenceDbModel.season,
//            queue = matchReferenceDbModel.queue,
//            role = matchReferenceDbModel.role,
//            timestamp = matchReferenceDbModel.timestamp
//        )
}
