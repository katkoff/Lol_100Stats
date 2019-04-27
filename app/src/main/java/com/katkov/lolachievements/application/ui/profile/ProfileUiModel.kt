package com.katkov.lolachievements.application.ui.profile

data class ProfileUiModel(
    var summonerName: String,
    var summonerLevel: Long,

    var totalGames: Int,
    var totalGameDuration: String,
    var wins: Int,

    var kills: Int,
    var deaths: Int,
    var assists: Int,

    var doubleKills: Int,
    var tripleKills: Int,
    var quadraKills: Int,
    var pentaKills: Int,

    var firstBloodKills: Int,
    var firstBloodAssists: Int,

    var firstTowerKills: Int,
    var firstTowerAssists: Int,

    var totalDamageTaken: Int,
    var physicalDamageTaken: Int,
    var magicalDamageTaken: Int,

    var totalDamageDealt: Int,
    var physicalDamageDealt: Int,
    var totalDamageDealtToChampions: Int,
    var physicalDamageDealtToChampions: Int,

    var totalHeal: Int,

    var wardsKilled: Int,
    var wardsPlaced: Int,

    var totalMinionsKilled: Int,
    var neutralMinionsKilled: Int,

    var goldEarned: Int,
    var goldSpent: Int,

    var firstHeraldKillsByTeam: Int,
    var firstBaronKillsByTeam: Int,
    var totalBaronKillsByTeam: Int,
    var firstBloodKillsByTeam: Int
)