package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MatchReferenceDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val lane: String,
    val gameId: Long,
    val champion: Int,
    val platformId: String,
    val season: Int,
    val queue: Int,
    val role: String,
    val timestamp: Long
)