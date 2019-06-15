package com.katkov.lolachievements.domain.model

import androidx.room.Entity

@Entity
data class MatchModel(
    val matchId: Long,
    val mapId: Int,
    val gameDuration: Long,
    val gameCreation: Long,
    val win: String,

    val kills: Int,
    val deaths: Int,
    val assists: Int,

    val firstBloodKill: Boolean,
    val firstBloodAssist: Boolean,
    val firstTowerKill: Boolean,
    val firstTowerAssist: Boolean,

    val doubleKills: Int,
    val tripleKills: Int,
    val quadraKills: Int,
    val pentaKills: Int,

    val firstRiftHerald: Boolean,
    val firstBaron: Boolean,
    val baronKills: Int,
    val firstBlood: Boolean,

    val totalDamageTaken: Int,
    val physicalDamageTaken: Int,
    val magicalDamageTaken: Int,

    val totalDamageDealt: Int,
    val physicalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val physicalDamageDealtToChampions: Int,

    val totalHeal: Int,

    val wardsKilled: Int,
    val wardsPlaced: Int,
    val totalMinionsKilled: Int,
    val neutralMinionsKilled: Int,
    val goldEarned: Int,
    val goldSpent: Int
)