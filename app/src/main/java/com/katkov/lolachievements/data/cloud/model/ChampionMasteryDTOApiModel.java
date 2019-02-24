package com.katkov.lolachievements.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class ChampionMasteryDTOApiModel {

    @SerializedName("chestGranted")
    private boolean chestGranted;
    @SerializedName("championLevel")
    private int championLevel;
    @SerializedName("championPoints")
    private int championPoints;
    @SerializedName("championId")
    private long championId;
    @SerializedName("championPointsUntilNextLevel")
    private long championPointsUntilNextLevel;
    @SerializedName("tokensEarned")
    private int tokensEarned;
    @SerializedName("championPointsSinceLastLevel")
    private long championPointsSinceLastLevel;
    @SerializedName("summonerId")
    private String summonerId;

    public ChampionMasteryDTOApiModel(
            boolean chestGranted,
            int championLevel,
            int championPoints,
            long championId,
            long championPointsUntilNextLevel,
            int tokensEarned,
            long championPointsSinceLastLevel,
            String summonerId) {
        this.chestGranted = chestGranted;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
        this.championId = championId;
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        this.tokensEarned = tokensEarned;
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
        this.summonerId = summonerId;
    }

    public boolean isChestGranted() {
        return chestGranted;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public int getChampionPoints() {
        return championPoints;
    }

    public long getChampionId() {
        return championId;
    }

    public long getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public int getTokensEarned() {
        return tokensEarned;
    }

    public long getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public String getSummonerId() {
        return summonerId;
    }
}
