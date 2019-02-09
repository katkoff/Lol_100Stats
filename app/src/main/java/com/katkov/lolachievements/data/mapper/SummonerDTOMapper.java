package com.katkov.lolachievements.data.mapper;

import com.katkov.lolachievements.data.cloud.api.model.SummonerDTOApiModel;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import javax.inject.Inject;

public class SummonerDTOMapper {

    @Inject
    public SummonerDTOMapper() {
    }

    public SummonerDTO map(SummonerDTOApiModel apiModel) {
        return new SummonerDTO(apiModel.getName(), apiModel.getSummonerLevel());
    }
}
