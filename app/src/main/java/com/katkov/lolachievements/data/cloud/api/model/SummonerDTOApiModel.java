package com.katkov.lolachievements.data.cloud.api.model;

import com.google.gson.annotations.SerializedName;

public class SummonerDTOApiModel {

    @SerializedName("profileIconId")
    private int profileIconId;
    @SerializedName("name")
    private String name;
    @SerializedName("puuid")
    private String puuid;
    @SerializedName("summonerLevel")
    private long summonerLevel;
    @SerializedName("revisionDate")
    private long revisionDate;
    @SerializedName("id")
    private String id;
    @SerializedName("accountId")
    private String accountId;

    public SummonerDTOApiModel(
            int profileIconId,
            String name,
            String puuid,
            long summonerLevel,
            long revisionDate,
            String id,
            String accountId) {
        this.profileIconId = profileIconId;
        this.name = name;
        this.puuid = puuid;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
        this.id = id;
        this.accountId = accountId;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public String getName() {
        return name;
    }

    public String getPuuid() {
        return puuid;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }
}
