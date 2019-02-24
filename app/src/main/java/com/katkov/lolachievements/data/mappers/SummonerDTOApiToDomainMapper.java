package com.katkov.lolachievements.data.mappers;

import com.katkov.lolachievements.data.cloud.model.SummonerDTOApiModel;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

public class SummonerDTOApiToDomainMapper extends Mapper<SummonerDTOApiModel, SummonerDTO> {

    @Inject
    public SummonerDTOApiToDomainMapper() {
    }

    @Override
    public SummonerDTO map(SummonerDTOApiModel source) {
        return new SummonerDTO(
                source.getName(),
                source.getSummonerLevel(),
                source.getId());
    }
}
