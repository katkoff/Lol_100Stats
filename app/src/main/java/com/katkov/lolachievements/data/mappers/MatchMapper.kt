package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.match.MatchApiModel
import com.katkov.lolachievements.data.cloud.model.match.ParticipantApiModel
import com.katkov.lolachievements.data.cloud.model.match.ParticipantIdentityApiModel
import com.katkov.lolachievements.data.cloud.model.match.TeamStatsApiModel
import com.katkov.lolachievements.data.local.model.MatchDbModel
import com.katkov.lolachievements.domain.model.MatchDomainModel
import javax.inject.Inject

class MatchMapper
@Inject
constructor() {

    /**
     * API to DB
     */
    fun mapApiMatchToDbList(
        matchApiList: List<MatchApiModel>,
        summonerName: String
    ): List<MatchDbModel> {
        val result = mutableListOf<MatchDbModel>()
        for (matchApiModel in matchApiList) {
            result.add(mapApiMatchToDbModel(matchApiModel, summonerName))
        }
        return result
    }

    fun mapApiMatchToDbModel(matchApiModel: MatchApiModel, summonerName: String): MatchDbModel =
        MatchDbModel(
            matchId = matchApiModel.gameId,
            mapId = matchApiModel.mapId,
            gameDuration = matchApiModel.gameDuration,
            win = getWin(matchApiModel, summonerName),
            kills = getKills(matchApiModel, summonerName),
            deaths = getDeaths(matchApiModel, summonerName),
            assists = getAssists(matchApiModel, summonerName),
            firstBloodKill = isFirstBloodKill(matchApiModel, summonerName),
            firstBloodAssist = isFirstBloodAssist(matchApiModel, summonerName),
            firstTowerKill = isFirstTowerKill(matchApiModel, summonerName),
            firstTowerAssist = isFirstTowerAssist(matchApiModel, summonerName),
            doubleKills = getDoubleKills(matchApiModel, summonerName),
            tripleKills = getTripleKills(matchApiModel, summonerName),
            quadraKills = getQuadraKills(matchApiModel, summonerName),
            pentaKills = getPentaKills(matchApiModel, summonerName),
            firstRiftHerald = isFirstRiftHerald(matchApiModel, summonerName),
            firstBaron = isFirstBaron(matchApiModel, summonerName),
            baronKills = getBaronKills(matchApiModel, summonerName),
            firstBlood = isFirstBlood(matchApiModel, summonerName),
            totalDamageTaken = getTotalDamageTaken(matchApiModel, summonerName),
            physicalDamageTaken = getPhysicalDamageTaken(matchApiModel, summonerName),
            magicalDamageTaken = getMagicalDamageTaken(matchApiModel, summonerName),
            totalDamageDealt = getTotalDamageDealt(matchApiModel, summonerName),
            physicalDamageDealt = getPhysicalDamageDealt(matchApiModel, summonerName),
            totalDamageDealtToChampions = getTotalDamageDealtToChampions(
                matchApiModel,
                summonerName),
            physicalDamageDealtToChampions = getPhysicalDamageDealtToChampions(
                matchApiModel,
                summonerName),
            totalHeal = getTotalHeal(matchApiModel, summonerName),
            wardsKilled = getWardsKilled(matchApiModel, summonerName),
            wardsPlaced = getWardsPlaced(matchApiModel, summonerName),
            totalMinionsKilled = getTotalMinionsKilled(matchApiModel, summonerName),
            neutralMinionsKilled = getNeutralMinionsKilled(matchApiModel, summonerName),
            goldEarned = getGoldEarned(matchApiModel, summonerName),
            goldSpent = getGoldSpent(matchApiModel, summonerName)
        )

    /**
     * DB to DOMAIN
     */
    fun mapDbToDomainList(matchDbList: List<MatchDbModel>): List<MatchDomainModel> {
        val result = mutableListOf<MatchDomainModel>()
        for (matchDbModel in matchDbList) {
            result.add(mapDbToDomainModel(matchDbModel))
        }
        return result
    }

    private fun mapDbToDomainModel(matchDbModel: MatchDbModel): MatchDomainModel =
        MatchDomainModel(
            matchId = matchDbModel.matchId,
            mapId = matchDbModel.mapId,
            gameDuration = matchDbModel.gameDuration,
            win = matchDbModel.win,
            kills = matchDbModel.kills,
            deaths = matchDbModel.deaths,
            assists = matchDbModel.assists,
            firstBloodKill = matchDbModel.firstBloodKill,
            firstBloodAssist = matchDbModel.firstBloodAssist,
            firstTowerKill = matchDbModel.firstTowerKill,
            firstTowerAssist = matchDbModel.firstTowerAssist,
            doubleKills = matchDbModel.doubleKills,
            tripleKills = matchDbModel.tripleKills,
            quadraKills = matchDbModel.quadraKills,
            pentaKills = matchDbModel.pentaKills,
            firstRiftHerald = matchDbModel.firstRiftHerald,
            firstBaron = matchDbModel.firstBaron,
            baronKills = matchDbModel.baronKills,
            firstBlood = matchDbModel.firstBlood,
            totalDamageTaken = matchDbModel.totalDamageTaken,
            physicalDamageTaken = matchDbModel.physicalDamageTaken,
            magicalDamageTaken = matchDbModel.magicalDamageTaken,
            totalDamageDealt = matchDbModel.totalDamageDealt,
            physicalDamageDealt = matchDbModel.physicalDamageDealt,
            totalDamageDealtToChampions = matchDbModel.totalDamageDealtToChampions,
            physicalDamageDealtToChampions = matchDbModel.physicalDamageDealtToChampions,
            totalHeal = matchDbModel.totalHeal,
            wardsKilled = matchDbModel.wardsKilled,
            wardsPlaced = matchDbModel.wardsPlaced,
            totalMinionsKilled = matchDbModel.totalMinionsKilled,
            neutralMinionsKilled = matchDbModel.neutralMinionsKilled,
            goldEarned = matchDbModel.goldEarned,
            goldSpent = matchDbModel.goldSpent
        )

    /**
     * GET PROPERTIES
     */
    private fun getWin(matchApiModel: MatchApiModel, summonerName: String): String {
        val teamStats = getTeamStats(matchApiModel, summonerName)
        return teamStats?.win ?: DEFAULT_STRING
    }

    private fun getKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.kills ?: DEFAULT_DIGIT
    }

    private fun getDeaths(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.deaths ?: DEFAULT_DIGIT
    }

    private fun getAssists(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.assists ?: DEFAULT_DIGIT
    }

    private fun isFirstBloodKill(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.firstBloodKill ?: DEFAULT_BOOLEAN
    }

    private fun isFirstBloodAssist(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.firstBloodAssist ?: DEFAULT_BOOLEAN
    }

    private fun isFirstTowerKill(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.firstTowerKill ?: DEFAULT_BOOLEAN
    }

    private fun isFirstTowerAssist(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.firstTowerAssist ?: DEFAULT_BOOLEAN
    }

    private fun getDoubleKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.doubleKills ?: DEFAULT_DIGIT
    }

    private fun getTripleKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.tripleKills ?: DEFAULT_DIGIT
    }

    private fun getQuadraKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.quadraKills ?: DEFAULT_DIGIT
    }

    private fun getPentaKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.pentaKills ?: DEFAULT_DIGIT
    }

    private fun isFirstRiftHerald(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val teamStats = getTeamStats(matchApiModel, summonerName)
        return teamStats?.firstRiftHerald ?: DEFAULT_BOOLEAN
    }

    private fun isFirstBaron(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val teamStats = getTeamStats(matchApiModel, summonerName)
        return teamStats?.firstBaron ?: DEFAULT_BOOLEAN
    }

    private fun getBaronKills(matchApiModel: MatchApiModel, summonerName: String): Int {
        val teamStats = getTeamStats(matchApiModel, summonerName)
        return teamStats?.baronKills ?: DEFAULT_DIGIT
    }

    private fun isFirstBlood(matchApiModel: MatchApiModel, summonerName: String): Boolean {
        val teamStats = getTeamStats(matchApiModel, summonerName)
        return teamStats?.firstBlood ?: DEFAULT_BOOLEAN
    }

    private fun getTotalDamageTaken(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.totalDamageTaken ?: DEFAULT_DIGIT
    }

    private fun getPhysicalDamageTaken(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.physicalDamageTaken ?: DEFAULT_DIGIT
    }

    private fun getMagicalDamageTaken(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.magicalDamageTaken ?: DEFAULT_DIGIT
    }

    private fun getTotalDamageDealt(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.totalDamageDealt ?: DEFAULT_DIGIT
    }

    private fun getPhysicalDamageDealt(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.physicalDamageDealt ?: DEFAULT_DIGIT
    }

    private fun getTotalDamageDealtToChampions(
        matchApiModel: MatchApiModel,
        summonerName: String
    ): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.totalDamageDealtToChampions ?: DEFAULT_DIGIT
    }

    private fun getPhysicalDamageDealtToChampions(
        matchApiModel: MatchApiModel,
        summonerName: String
    ): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.physicalDamageDealtToChampions ?: DEFAULT_DIGIT
    }

    private fun getTotalHeal(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.totalHeal ?: DEFAULT_DIGIT
    }

    private fun getWardsKilled(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.wardsKilled ?: DEFAULT_DIGIT
    }

    private fun getWardsPlaced(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.wardsPlaced ?: DEFAULT_DIGIT
    }

    private fun getTotalMinionsKilled(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.totalMinionsKilled ?: DEFAULT_DIGIT
    }

    private fun getNeutralMinionsKilled(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.neutralMinionsKilled ?: DEFAULT_DIGIT
    }

    private fun getGoldEarned(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.goldEarned ?: DEFAULT_DIGIT
    }

    private fun getGoldSpent(matchApiModel: MatchApiModel, summonerName: String): Int {
        val participant = getParticipant(matchApiModel, summonerName)
        return participant?.stats?.goldSpent ?: DEFAULT_DIGIT
    }

    /**
     * COMMON NEEDS
     */
    private fun getParticipantIdentity(
        summonerName: String,
        participantIdentities: List<ParticipantIdentityApiModel>
    ): ParticipantIdentityApiModel? {
        for (participantIdentity in participantIdentities) {
            if (participantIdentity.player.summonerName == summonerName) {
                return participantIdentity
            }
        }
        return null
    }

    private fun getTeamStats(
        matchApiModel: MatchApiModel,
        summonerName: String
    ): TeamStatsApiModel? {
        val teamId = getParticipant(matchApiModel, summonerName)!!.teamId
        for (team in matchApiModel.teams) {
            if (team.teamId == teamId) {
                return team
            }
        }
        return null
    }

    private fun getParticipant(
        matchApiModel: MatchApiModel,
        summonerName: String
    ): ParticipantApiModel? {
        val participantIdentity = getParticipantIdentity(
            summonerName,
            matchApiModel.participantIdentities)
        val participantId = participantIdentity!!.participantId

        for (participant in matchApiModel.participants) {
            if (participant.participantId == participantId) {
                return participant
            }
        }
        return null
    }

    companion object {
        const val DEFAULT_STRING = ""
        const val DEFAULT_DIGIT = 0
        const val DEFAULT_BOOLEAN = false
    }
}