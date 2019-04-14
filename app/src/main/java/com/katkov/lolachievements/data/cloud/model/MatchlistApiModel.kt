package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class MatchlistApiModel(
    @SerializedName("matches")
    val matches: List<MatchReferenceApiModel>,
    @SerializedName("totalGames")
    val totalGames: Int,
    @SerializedName("startIndex")
    val startIndex: Int,
    @SerializedName("endIndex")
    val endIndex: Int
)