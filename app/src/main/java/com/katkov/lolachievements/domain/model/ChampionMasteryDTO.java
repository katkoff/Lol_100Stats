package com.katkov.lolachievements.domain.model;

public class ChampionMasteryDTO {

    private boolean chestGranted;
    private int championLevel;
    private int championPoints;
    private long championId;
    private long championPointsUntilNextLevel;
    private int tokensEarned;
    private long championPointsSinceLastLevel;
    private String summonerId;

    public ChampionMasteryDTO(
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
