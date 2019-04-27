package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class RuneApiModel(
    @SerializedName("runeId")
    val runeId: Int,
    @SerializedName("rank")
    val rank: Int
)