package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.MasteryApiDto
import com.katkov.lolachievements.data.local.model.MasteryDbModel
import com.katkov.lolachievements.domain.model.MasteryModel
import javax.inject.Inject

class MasteryMapper
@Inject
constructor() {

    fun mapApiToDbList(masteryApiList: List<MasteryApiDto>): List<MasteryDbModel> {
        val result = mutableListOf<MasteryDbModel>()
        for (masteryApiDto in masteryApiList) {
            result.add(mapApiToDbModel(masteryApiDto))
        }
        return result
    }

    fun mapApiToDbModel(masteryApiDto: MasteryApiDto): MasteryDbModel {
        return MasteryDbModel(
            isChestGranted = masteryApiDto.isChestGranted,
            championLevel = masteryApiDto.championLevel,
            championPoints = masteryApiDto.championPoints,
            championId = masteryApiDto.championId,
            championPointsUntilNextLevel = masteryApiDto.championPointsUntilNextLevel,
            tokensEarned = masteryApiDto.tokensEarned,
            championPointsSinceLastLevel = masteryApiDto.championPointsSinceLastLevel,
            summonerId = masteryApiDto.summonerId
        )
    }

    fun mapDbToDomainModel(masteryDbModel: MasteryDbModel?): MasteryModel? {
        return masteryDbModel?.let {
            MasteryModel(
                isChestGranted = masteryDbModel.isChestGranted,
                championLevel = masteryDbModel.championLevel,
                championPoints = masteryDbModel.championPoints,
                championId = masteryDbModel.championId,
                championPointsUntilNextLevel = masteryDbModel.championPointsUntilNextLevel,
                tokensEarned = masteryDbModel.tokensEarned,
                championPointsSinceLastLevel = masteryDbModel.championPointsSinceLastLevel,
                summonerId = masteryDbModel.summonerId
            )
        }
    }
}
