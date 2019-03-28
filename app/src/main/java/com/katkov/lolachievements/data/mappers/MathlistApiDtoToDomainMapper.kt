package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.MatchlistApiDto
import com.katkov.lolachievements.domain.model.MatchlistDto
import javax.inject.Inject

class MathlistApiDtoToDomainMapper
@Inject
constructor() : Mapper<MatchlistApiDto, MatchlistDto>() {

    override fun map(source: MatchlistApiDto): MatchlistDto {
        return MatchlistDto(source.totalGames)
    }
}