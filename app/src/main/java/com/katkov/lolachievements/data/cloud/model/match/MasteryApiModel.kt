package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class MasteryApiModel(
    @SerializedName("masteryId")
    val masteryId: Int,
    @SerializedName("rank")
    val rank: Int
)