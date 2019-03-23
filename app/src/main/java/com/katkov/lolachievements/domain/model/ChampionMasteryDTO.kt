package com.katkov.lolachievements.domain.model

data class ChampionMasteryDTO(
        val isChestGranted: Boolean,
        val championLevel: Int,
        val championPoints: Int,
        val championId: Long,
        val championPointsUntilNextLevel: Long,
        val tokensEarned: Int,
        val championPointsSinceLastLevel: Long,
        val summonerId: String)
