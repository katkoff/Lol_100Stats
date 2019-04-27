package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class ParticipantApiModel(
    @SerializedName("stats")
    val stats: ParticipantStatsApiModel,
    @SerializedName("participantId")
    val participantId: Int,
    @SerializedName("runes")
    val runes: List<RuneApiModel>,
    @SerializedName("timeline")
    val timeline: ParticipantTimelineApiModel,
    @SerializedName("teamId")
    val teamId: Int,
    @SerializedName("spell2Id")
    val spell2Id: Int,
    @SerializedName("masteries")
    val masteries: List<MasteryApiModel>,
    @SerializedName("highestAchievedSeasonTier")
    val highestAchievedSeasonTier: String,
    @SerializedName("spell1Id")
    val spell1Id: Int,
    @SerializedName("championId")
    val championId: Int
)