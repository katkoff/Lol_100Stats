package com.katkov.lolachievements.application.ui.profile

import com.katkov.lolachievements.domain.model.MatchDomainModel
import javax.inject.Inject

class ProfileMapper
@Inject
constructor() {

    fun mapTotalGameDuration(matches: List<MatchDomainModel>): String {
        var totalSeconds: Long = 0
        matches.forEach { totalSeconds += it.gameDuration }

        val toDays = totalSeconds / 60 / 60 / 24
        val toHours = totalSeconds / 60 / 60 % 24
        val toMinutes = totalSeconds / 60 % 60

        return "$toDays days, $toHours hours, $toMinutes min"
    }

    fun mapWins(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.win == "Win") result += 1 }
        return result
    }

    fun mapKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.kills }
        return result
    }

    fun mapDeath(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.deaths }
        return result
    }

    fun mapAssists(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.assists }
        return result
    }

    fun mapDoubleKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.doubleKills }
        return result
    }

    fun mapTripleKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.tripleKills }
        return result
    }

    fun mapQuadraKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.quadraKills }
        return result
    }

    fun mapPentaKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.pentaKills }
        return result
    }

    fun mapFirstBloodKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBloodKill) result += 1 }
        return result
    }

    fun mapFirstBloodAssists(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBloodAssist) result += 1 }
        return result
    }

    fun mapFirstTowerKills(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstTowerKill) result += 1 }
        return result
    }

    fun mapFirstTowerAssists(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstTowerAssist) result += 1 }
        return result
    }

    fun mapTotalDamageTaken(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageTaken }
        return result
    }

    fun mapPhysicalDamageTaken(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageTaken }
        return result
    }

    fun mapMagicalDamageTaken(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.magicalDamageTaken }
        return result
    }

    fun mapTotalDamageDealt(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageDealt }
        return result
    }

    fun mapPhysicalDamageDealt(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageDealt }
        return result
    }

    fun mapTotalDamageDealtToChampions(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageDealtToChampions }
        return result
    }

    fun mapPhysicalDamageDealtToChampions(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageDealtToChampions }
        return result
    }

    fun mapTotalHeal(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.totalHeal }
        return result
    }

    fun mapWardsKilled(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.wardsKilled }
        return result
    }

    fun mapWardsPlaced(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.wardsPlaced }
        return result
    }

    fun mapTotalMinionsKilled(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.totalMinionsKilled }
        return result
    }

    fun mapNeutralMinionsKilled(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.neutralMinionsKilled }
        return result
    }

    fun mapGoldEarned(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.goldEarned }
        return result
    }

    fun mapGoldSpent(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.goldSpent }
        return result
    }

    fun mapFirstHeraldKillsByTeam(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstRiftHerald) result += 1 }
        return result
    }

    fun mapFirstBaronKillsByTeam(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBaron) result += 1 }
        return result
    }

    fun mapTotalBaronKillsByTeam(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { result += it.baronKills }
        return result
    }

    fun mapFirstBloodKillsByTeam(matches: List<MatchDomainModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBaron) result += 1 }
        return result
    }
}