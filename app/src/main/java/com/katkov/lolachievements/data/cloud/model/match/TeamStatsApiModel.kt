package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class TeamStatsApiModel(
    @SerializedName("firstDragon")
    val firstDragon: Boolean,
    @SerializedName("firstInhibitor")
    val firstInhibitor: Boolean,
    @SerializedName("bans")
    val bans: List<TeamBansApiModel>,
    @SerializedName("baronKills")
    val baronKills: Int,
    @SerializedName("firstRiftHerald")
    val firstRiftHerald: Boolean,
    @SerializedName("firstBaron")
    val firstBaron: Boolean,
    @SerializedName("riftHeraldKills")
    val riftHeraldKills: Int,
    @SerializedName("firstBlood")
    val firstBlood: Boolean,
    @SerializedName("teamId")
    val teamId: Int,
    @SerializedName("firstTower")
    val firstTower: Boolean,
    @SerializedName("vilemawKills")
    val vilemawKills: Int,
    @SerializedName("inhibitorKills")
    val inhibitorKills: Int,
    @SerializedName("towerKills")
    val towerKills: Int,
    @SerializedName("dominionVictoryScore")
    val dominionVictoryScore: Int,
    @SerializedName("win")
    val win: String,
    @SerializedName("dragonKills")
    val dragonKills: Int
)