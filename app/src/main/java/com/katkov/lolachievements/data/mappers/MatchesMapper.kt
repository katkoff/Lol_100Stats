package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.MatchReferenceApiDto
import com.katkov.lolachievements.data.cloud.model.MatchlistApiDto
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
    fun matchlistApiToDbModel(matchlistApiDto: MatchlistApiDto): MatchlistDbModel =
        MatchlistDbModel(
            matches = matchesApiToDomain(matchlistApiDto.matches),
            totalGames = matchlistApiDto.totalGames,
            startIndex = matchlistApiDto.startIndex,
            endIndex = matchlistApiDto.endIndex
        )

    private fun matchesApiToDomain(matchReferenceApiList: List<MatchReferenceApiDto>): List<MatchReferenceModel> {
        val resultList = mutableListOf<MatchReferenceModel>()
        for (item in matchReferenceApiList) {
            resultList.add(matchReferenceApiToDomainModel(item))
        }
        return resultList
    }

    private fun matchReferenceApiToDomainModel(matchReferenceApiDto: MatchReferenceApiDto): MatchReferenceModel =
        MatchReferenceModel(
            lane = matchReferenceApiDto.lane,
            gameId = matchReferenceApiDto.gameId,
            champion = matchReferenceApiDto.champion,
            platformId = matchReferenceApiDto.platformId,
            season = matchReferenceApiDto.season,
            queue = matchReferenceApiDto.queue,
            role = matchReferenceApiDto.role,
            timestamp = matchReferenceApiDto.timestamp
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
