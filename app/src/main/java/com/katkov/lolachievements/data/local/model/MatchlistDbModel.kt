package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.katkov.lolachievements.domain.model.MatchReferenceModel

@Entity
data class MatchlistDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val matches: List<MatchReferenceModel>,
    val totalGames: Int,
    val startIndex: Int,
    val endIndex: Int
)