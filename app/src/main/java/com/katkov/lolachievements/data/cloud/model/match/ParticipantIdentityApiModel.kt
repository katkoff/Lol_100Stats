package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class ParticipantIdentityApiModel(
    @SerializedName("player")
    val player: PlayerApiModel,
    @SerializedName("participantId")
    val participantId: Int
)