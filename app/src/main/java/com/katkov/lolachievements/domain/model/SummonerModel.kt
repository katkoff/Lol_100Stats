package com.katkov.lolachievements.domain.model

data class SummonerModel(
    val profileIconId: Int,
    val name: String,
    val puuid: String,
    val summonerLevel: Long,
    val revisionDate: Long,
    val encryptedId: String,
    val encryptedAccountId: String
)
