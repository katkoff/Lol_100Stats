package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryDTOApiModel
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO

import javax.inject.Inject

class ChampionMasteryDTOApiToDomainMapper
@Inject
constructor() : Mapper<ChampionMasteryDTOApiModel, ChampionMasteryDTO>() {

    override fun map(source: ChampionMasteryDTOApiModel): ChampionMasteryDTO {
        return ChampionMasteryDTO(
                source.isChestGranted,
                source.championLevel,
                source.championPoints,
                source.championId,
                source.championPointsUntilNextLevel,
                source.tokensEarned,
                source.championPointsSinceLastLevel,
                source.summonerId)
    }
}
