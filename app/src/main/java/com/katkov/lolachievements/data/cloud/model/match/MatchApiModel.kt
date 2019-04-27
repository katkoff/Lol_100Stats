package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class MatchApiModel(
    @SerializedName("seasonId")
    val seasonId: Int,
    @SerializedName("queueId")
    val queueId: Int,
    @SerializedName("gameId")
    val gameId: Long,
    @SerializedName("participantIdentities")
    val participantIdentities: List<ParticipantIdentityApiModel>,
    @SerializedName("gameVersion")
    val gameVersion: String,
    @SerializedName("platformId")
    val platformId: String,
    @SerializedName("gameMode")
    val gameMode: String,
    @SerializedName("mapId")
    val mapId: Int,
    @SerializedName("gameType")
    val gameType: String,
    @SerializedName("teams")
    val teams: List<TeamStatsApiModel>,
    @SerializedName("participants")
    val participants: List<ParticipantApiModel>,
    @SerializedName("gameDuration")
    val gameDuration: Long,
    @SerializedName("gameCreation")
    val gameCreation: Long
)