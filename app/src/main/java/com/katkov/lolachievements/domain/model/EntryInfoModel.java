package com.katkov.lolachievements.domain.model;

public class EntryInfoModel {

    private String summonerName;
    private String serverName;

    public EntryInfoModel(String summonerName, String serverName) {
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
