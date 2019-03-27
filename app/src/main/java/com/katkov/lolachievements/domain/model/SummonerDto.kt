package com.katkov.lolachievements.domain.model

data class SummonerDto(
    val summonerName: String,
    val summonerLevel: Long,
    val id: String,
    val accountId: String
)
