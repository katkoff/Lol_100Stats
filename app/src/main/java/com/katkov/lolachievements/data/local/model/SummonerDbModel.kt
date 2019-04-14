package com.katkov.lolachievements.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SummonerDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val encryptedId: String,
    val encryptedAccountId: String
)