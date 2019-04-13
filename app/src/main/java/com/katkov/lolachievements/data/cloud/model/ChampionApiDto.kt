package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class ChampionApiDto(
    @SerializedName("chestGranted")
    val isChestGranted: Boolean,
    @SerializedName("championLevel")
    val championLevel: Int,
    @SerializedName("championPoints")
    val championPoints: Int,
    @SerializedName("championId")
    val championId: Long,
    @SerializedName("championPointsUntilNextLevel")
    val championPointsUntilNextLevel: Long,
    @SerializedName("tokensEarned")
    val tokensEarned: Int,
    @SerializedName("championPointsSinceLastLevel")
    val championPointsSinceLastLevel: Long,
    @SerializedName("summonerId")
    val summonerId: String
)
