package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class PlayerApiModel(
    @SerializedName("currentPlatformId")
    val currentPlatformId: String,
    @SerializedName("summonerName")
    val summonerName: String,
    @SerializedName("matchHistoryUri")
    val matchHistoryUri: String,
    @SerializedName("platformId")
    val platformId: String,
    @SerializedName("currentAccountId")
    val currentAccountId: String,
    @SerializedName("profileIcon")
    val profileIcon: Int,
    @SerializedName("summonerId")
    val summonerId: String,
    @SerializedName("accountId")
    val accountId: String
)