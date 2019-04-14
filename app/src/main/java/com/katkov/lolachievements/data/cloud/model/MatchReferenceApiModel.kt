package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class MatchReferenceApiModel(
    @SerializedName("lane")
    val lane: String,
    @SerializedName("gameId")
    val gameId: Long,
    @SerializedName("champion")
    val champion: Int,
    @SerializedName("platformId")
    val platformId: String,
    @SerializedName("season")
    val season: Int,
    @SerializedName("queue")
    val queue: Int,
    @SerializedName("role")
    val role: String,
    @SerializedName("timestamp")
    val timestamp: Long
)