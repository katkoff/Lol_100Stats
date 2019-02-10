package com.katkov.lolachievements.domain.model;

public class SummonerEntry {

    private String summonerName;
    private String serverName;

    public SummonerEntry(String summonerName, String serverName) {
        this.summonerName = summonerName;
        this.serverName = serverName;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getServerName() {
        return serverName;
    }
}
