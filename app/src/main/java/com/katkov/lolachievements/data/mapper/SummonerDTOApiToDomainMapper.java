package com.katkov.lolachievements.data.mapper;

import com.katkov.lolachievements.data.cloud.api.model.SummonerDTOApiModel;
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
