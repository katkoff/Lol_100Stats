package com.katkov.lolachievements.domain.model

data class MatchReferenceModel(
    val lane: String,
    val gameId: Long,
    val champion: Int,
    val platformId: String,
    val season: Int,
    val queue: Int,
    val role: String,
    val timestamp: Long
)