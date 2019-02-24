package com.katkov.lolachievements.data.mappers;

import com.katkov.lolachievements.data.cloud.model.SummonerDTOApiModel;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

public class SummonerDTOApiToDomainMapper {

    @Inject
    public SummonerDTOApiToDomainMapper() {
    }

    public SummonerDTO map(SummonerDTOApiModel apiModel) {
        return new SummonerDTO(apiModel.getName(), apiModel.getSummonerLevel());
    }
}
