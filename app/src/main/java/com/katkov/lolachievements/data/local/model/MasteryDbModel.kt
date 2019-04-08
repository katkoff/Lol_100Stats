package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MasteryDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val isChestGranted: Boolean,
    val championLevel: Int,
    val championPoints: Int,
    val championId: Long,
    val championPointsUntilNextLevel: Long,
    val tokensEarned: Int,
    val championPointsSinceLastLevel: Long,
    val summonerId: String
)
