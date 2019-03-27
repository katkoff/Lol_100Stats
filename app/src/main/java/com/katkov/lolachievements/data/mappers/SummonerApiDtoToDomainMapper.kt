package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.SummonerApiDto
import com.katkov.lolachievements.domain.model.SummonerDto

import javax.inject.Inject

class SummonerApiDtoToDomainMapper
@Inject
constructor() : Mapper<SummonerApiDto, SummonerDto>() {

    override fun map(source: SummonerApiDto): SummonerDto {
        return SummonerDto(
            source.name,
            source.summonerLevel,
            source.id,
            source.accountId)
    }
}
