package com.katkov.lolachievements.domain.model

data class MatchlistModel(
    val matches: List<MatchReferenceModel>,
    val totalGames: Int,
    val startIndex: Int,
    val endIndex: Int
)