package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val matchId: Long,
    val mapId: Int,
    val gameDuration: Long,
    val win: Boolean,

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
    val magicalDamageTaken: Int,

    val physicalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val physicalDamageDealtToChampions: Int,
    val totalDamageDealt: Int,

    val totalHeal: Int,

    val wardsKilled: Int,
    val wardsPlaced: Int,
    val neutralMinionsKilled: Int,
    val totalMinionsKilled: Int,
    val goldEarned: Int,
    val goldSpent: Int


)