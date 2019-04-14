package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.MatchReferenceApiModel
import com.katkov.lolachievements.data.local.model.MatchReferenceDbModel
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import javax.inject.Inject

class MatchesMapper
@Inject
constructor() {

    fun mapApiToDbList(matchReferenceApiList: List<MatchReferenceApiModel>): List<MatchReferenceDbModel> {
        val result = mutableListOf<MatchReferenceDbModel>()
        for (matchReferenceApi in matchReferenceApiList) {
            result.add(mapApiToDbModel(matchReferenceApi))
        }
        return result
    }

    private fun mapApiToDbModel(matchReferenceApiModel: MatchReferenceApiModel): MatchReferenceDbModel =
        MatchReferenceDbModel(
            lane = matchReferenceApiModel.lane,
            gameId = matchReferenceApiModel.gameId,
            champion = matchReferenceApiModel.champion,
            platformId = matchReferenceApiModel.platformId,
            season = matchReferenceApiModel.season,
            queue = matchReferenceApiModel.queue,
            role = matchReferenceApiModel.role,
            timestamp = matchReferenceApiModel.timestamp
        )

    fun mapDbToDomainList(matchReferenceDbList: List<MatchReferenceDbModel>): List<MatchReferenceModel> {
        val result = mutableListOf<MatchReferenceModel>()
        for (matchReferenceDbModel in matchReferenceDbList) {
            result.add(mapDbToDomainModel(matchReferenceDbModel))
        }
        return result
    }

    private fun mapDbToDomainModel(matchReferenceDbModel: MatchReferenceDbModel): MatchReferenceModel =
        MatchReferenceModel(
            lane = matchReferenceDbModel.lane,
            gameId = matchReferenceDbModel.gameId,
            champion = matchReferenceDbModel.champion,
            platformId = matchReferenceDbModel.platformId,
            season = matchReferenceDbModel.season,
            queue = matchReferenceDbModel.queue,
            role = matchReferenceDbModel.role,
            timestamp = matchReferenceDbModel.timestamp
        )
}
