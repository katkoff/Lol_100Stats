package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.SummonerDTOApiModel
import com.katkov.lolachievements.domain.model.SummonerDTO

import javax.inject.Inject

class SummonerDTOApiToDomainMapper
@Inject
constructor() : Mapper<SummonerDTOApiModel, SummonerDTO>() {

    override fun map(source: SummonerDTOApiModel): SummonerDTO {
        return SummonerDTO(
                source.name,
                source.summonerLevel,
                source.id)
    }
}
