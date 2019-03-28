package com.katkov.lolachievements.domain.model

data class AchievementModel(
    val iconUrl: String,
    val title: String,
    val description: String,
    val progressMin: Int,
    val progressMax: Int,
    val progress: Int
)