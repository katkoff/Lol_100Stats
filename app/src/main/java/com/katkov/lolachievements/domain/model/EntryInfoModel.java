package com.katkov.lolachievements.domain.model;

public class EntryInfoModel {

    private String summonerName;
    private String serverCode;

    public EntryInfoModel(String summonerName, String serverName) {
        this.summonerName = summonerName;
        this.serverCode = serverName;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public String getServerCode() {
        return serverCode;
    }
}
