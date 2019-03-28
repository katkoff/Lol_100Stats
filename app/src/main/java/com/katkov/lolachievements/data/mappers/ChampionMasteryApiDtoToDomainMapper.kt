package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryApiDto
import com.katkov.lolachievements.domain.model.ChampionMasteryDto

import javax.inject.Inject

class ChampionMasteryApiDtoToDomainMapper
@Inject
constructor() : Mapper<ChampionMasteryApiDto, ChampionMasteryDto>() {

    override fun map(source: ChampionMasteryApiDto): ChampionMasteryDto {
        return ChampionMasteryDto(
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
