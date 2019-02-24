package com.katkov.lolachievements.domain.model;

public class SummonerDTO {

    private String summonerName;
    private long summonerLevel;
    private String id;

    public SummonerDTO(String summonerName, long summonerLevel, String id) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }
}
