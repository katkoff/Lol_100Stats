package com.katkov.lolachievements.data.mappers;

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryDTOApiModel;
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO;

import javax.inject.Inject;

public class ChampionMasteryDTOApiToDomainMapper
        extends Mapper<ChampionMasteryDTOApiModel, ChampionMasteryDTO> {

    @Inject
    public ChampionMasteryDTOApiToDomainMapper() {
    }

    @Override
    public ChampionMasteryDTO map(ChampionMasteryDTOApiModel source) {
        return new ChampionMasteryDTO(
                source.isChestGranted(),
                source.getChampionLevel(),
                source.getChampionPoints(),
                source.getChampionId(),
                source.getChampionPointsUntilNextLevel(),
                source.getTokensEarned(),
                source.getChampionPointsSinceLastLevel(),
                source.getSummonerId());
    }
}
