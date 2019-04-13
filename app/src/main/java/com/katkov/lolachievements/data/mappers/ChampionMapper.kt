package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.ChampionApiDto
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import com.katkov.lolachievements.domain.model.ChampionModel
import javax.inject.Inject

class ChampionMapper
@Inject
constructor() {

    fun mapApiToDbList(championApiList: List<ChampionApiDto>): List<ChampionDbModel> {
        val result = mutableListOf<ChampionDbModel>()
        for (masteryApiDto in championApiList) {
            result.add(mapApiToDbModel(masteryApiDto))
        }
        return result
    }

    private fun mapApiToDbModel(championApiDto: ChampionApiDto): ChampionDbModel = ChampionDbModel(
        isChestGranted = championApiDto.isChestGranted,
        championLevel = championApiDto.championLevel,
        championPoints = championApiDto.championPoints,
        championId = championApiDto.championId,
        championPointsUntilNextLevel = championApiDto.championPointsUntilNextLevel,
        tokensEarned = championApiDto.tokensEarned,
        championPointsSinceLastLevel = championApiDto.championPointsSinceLastLevel,
        summonerId = championApiDto.summonerId
    )

    fun mapDbToDomainList(championDbList: List<ChampionDbModel>): List<ChampionModel> {
        val result = mutableListOf<ChampionModel>()
        for (masteryDbModel in championDbList) {
            result.add(mapDbToDomainModel(masteryDbModel))
        }
        return result
    }

    private fun mapDbToDomainModel(championDbModel: ChampionDbModel): ChampionModel = ChampionModel(
        isChestGranted = championDbModel.isChestGranted,
        championLevel = championDbModel.championLevel,
        championPoints = championDbModel.championPoints,
        championId = championDbModel.championId,
        championPointsUntilNextLevel = championDbModel.championPointsUntilNextLevel,
        tokensEarned = championDbModel.tokensEarned,
        championPointsSinceLastLevel = championDbModel.championPointsSinceLastLevel,
        summonerId = championDbModel.summonerId
    )
}
