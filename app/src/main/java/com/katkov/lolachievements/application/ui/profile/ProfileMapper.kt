package com.katkov.lolachievements.application.ui.profile

import com.katkov.lolachievements.domain.model.MatchModel
import java.sql.Date
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import javax.inject.Inject

class ProfileMapper
@Inject
constructor() {

    fun mapFirstGameCreation(matches: List<MatchModel>): String {
        //todo Разобраться с Апи в threeten и с warning simpleDateFormat
        val firstGameCreationTimeStamp = matches[matches.lastIndex].gameCreation
//        val result = LocalDateTime.ofInstant(
//            Instant.ofEpochMilli(firstGameCreationTimeStamp),
//            ZoneId.systemDefault()
//        )
        val date = Date(firstGameCreationTimeStamp)
        val dateString = SimpleDateFormat("dd.MM.yyy hh:mm").format(date)
        return dateString
    }

    fun mapTotalGameDuration(matches: List<MatchModel>): String {
        var totalSeconds: Long = 0
        matches.forEach { totalSeconds += it.gameDuration }

        val toDays = totalSeconds / 60 / 60 / 24
        val toHours = totalSeconds / 60 / 60 % 24
        val toMinutes = totalSeconds / 60 % 60

        return "$toDays days, $toHours hours, $toMinutes min"
    }

    fun mapWins(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.win == "Win") result += 1 }
        return result
    }

    fun mapWinRate(matches: List<MatchModel>): String {
        val wins = mapWins(matches)
        val winRate: Double = wins.toDouble()*100 / matches.size
        val formatter = DecimalFormat("##.##")
        val winRateRounding = formatter.format(winRate)
        return "$winRateRounding %"
    }

    fun mapKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.kills }
        return result
    }

    fun mapDeath(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.deaths }
        return result
    }

    fun mapAssists(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.assists }
        return result
    }

    fun mapDoubleKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.doubleKills }
        return result
    }

    fun mapTripleKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.tripleKills }
        return result
    }

    fun mapQuadraKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.quadraKills }
        return result
    }

    fun mapPentaKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.pentaKills }
        return result
    }

    fun mapFirstBloodKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBloodKill) result += 1 }
        return result
    }

    fun mapFirstBloodAssists(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBloodAssist) result += 1 }
        return result
    }

    fun mapFirstTowerKills(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstTowerKill) result += 1 }
        return result
    }

    fun mapFirstTowerAssists(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstTowerAssist) result += 1 }
        return result
    }

    fun mapTotalDamageTaken(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageTaken }
        return result
    }

    fun mapPhysicalDamageTaken(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageTaken }
        return result
    }

    fun mapMagicalDamageTaken(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.magicalDamageTaken }
        return result
    }

    fun mapTotalDamageDealt(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageDealt }
        return result
    }

    fun mapPhysicalDamageDealt(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageDealt }
        return result
    }

    fun mapTotalDamageDealtToChampions(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.totalDamageDealtToChampions }
        return result
    }

    fun mapPhysicalDamageDealtToChampions(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.physicalDamageDealtToChampions }
        return result
    }

    fun mapTotalHeal(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.totalHeal }
        return result
    }

    fun mapWardsKilled(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.wardsKilled }
        return result
    }

    fun mapWardsPlaced(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.wardsPlaced }
        return result
    }

    fun mapTotalMinionsKilled(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.totalMinionsKilled }
        return result
    }

    fun mapNeutralMinionsKilled(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.neutralMinionsKilled }
        return result
    }

    fun mapGoldEarned(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.goldEarned }
        return result
    }

    fun mapGoldSpent(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.goldSpent }
        return result
    }

    fun mapFirstHeraldKillsByTeam(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstRiftHerald) result += 1 }
        return result
    }

    fun mapFirstBaronKillsByTeam(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBaron) result += 1 }
        return result
    }

    fun mapTotalBaronKillsByTeam(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { result += it.baronKills }
        return result
    }

    fun mapFirstBloodKillsByTeam(matches: List<MatchModel>): Int {
        var result = 0
        matches.forEach { if (it.firstBaron) result += 1 }
        return result
    }
}