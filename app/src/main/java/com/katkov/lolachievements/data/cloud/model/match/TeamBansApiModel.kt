package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class TeamBansApiModel(
    @SerializedName("pickTurn")
    val pickTurn: Int,
    @SerializedName("championId")
    val championId: Int
)