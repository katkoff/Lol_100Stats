package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class ChampionMasteryDTOApiModel(
    @field:SerializedName("chestGranted")
    val isChestGranted: Boolean,
    @field:SerializedName("championLevel")
    val championLevel: Int,
    @field:SerializedName("championPoints")
    val championPoints: Int,
    @field:SerializedName("championId")
    val championId: Long,
    @field:SerializedName("championPointsUntilNextLevel")
    val championPointsUntilNextLevel: Long,
    @field:SerializedName("tokensEarned")
    val tokensEarned: Int,
    @field:SerializedName("championPointsSinceLastLevel")
    val championPointsSinceLastLevel: Long,
    @field:SerializedName("summonerId")
    val summonerId: String
)
