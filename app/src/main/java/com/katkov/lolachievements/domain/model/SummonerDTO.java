package com.katkov.lolachievements.domain.model;

public class SummonerDTO {

    private String summonerName;
    private long summonerLevel;

    public SummonerDTO(String summonerName, long summonerLevel) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }
}
