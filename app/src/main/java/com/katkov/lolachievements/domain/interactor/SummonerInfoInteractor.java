package com.katkov.lolachievements.domain.interactor;

import com.katkov.lolachievements.data.cloud.repository.ChampionMasteryRepository;
import com.katkov.lolachievements.data.cloud.repository.SummonerInfoRepository;
import com.katkov.lolachievements.domain.model.ChampionMasteryDTO;
import com.katkov.lolachievements.domain.model.SummonerDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class SummonerInfoInteractor {

    private final SummonerInfoRepository summonerInfoRepository;
    private final ChampionMasteryRepository championMasteryRepository;

    @Inject
    public SummonerInfoInteractor(SummonerInfoRepository summonerInfoRepository, ChampionMasteryRepository championMasteryRepository) {
        this.summonerInfoRepository = summonerInfoRepository;
        this.championMasteryRepository = championMasteryRepository;
    }

    public Single<SummonerDTO> getSummonerDTO(String name) {
        return summonerInfoRepository.getSummonerDTO(name);
    }

    public Single<List<ChampionMasteryDTO>> getChampionsMastery(String encryptedSummonerId) {
        return championMasteryRepository.getChampionsMastery(encryptedSummonerId);
    }
}
