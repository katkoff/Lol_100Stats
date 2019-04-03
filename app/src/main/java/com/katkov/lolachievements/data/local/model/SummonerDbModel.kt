package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SummonerDbModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val encryptedId: String,
    val encryptedAccountId: String
)