package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.SummonerApiModel
import com.katkov.lolachievements.data.local.model.SummonerDbModel
import com.katkov.lolachievements.domain.model.SummonerModel

import javax.inject.Inject

class SummonerMapper
@Inject
constructor() {

    fun mapApiToDomainModel(summonerApiModel: SummonerApiModel): SummonerModel = SummonerModel(
        profileIconId = summonerApiModel.profileIconId,
        name = summonerApiModel.name,
        puuid = summonerApiModel.puuid,
        summonerLevel = summonerApiModel.summonerLevel,
        revisionDate = summonerApiModel.revisionDate,
        encryptedId = summonerApiModel.encryptedId,
        encryptedAccountId = summonerApiModel.accountId
    )

    fun mapApiToDbModel(summonerApiModel: SummonerApiModel): SummonerDbModel = SummonerDbModel(
        profileIconId = summonerApiModel.profileIconId,
        name = summonerApiModel.name,
        puuid = summonerApiModel.puuid,
        summonerLevel = summonerApiModel.summonerLevel,
        revisionDate = summonerApiModel.revisionDate,
        encryptedId = summonerApiModel.encryptedId,
        encryptedAccountId = summonerApiModel.accountId
    )

    fun mapDbToDomainModel(summonerDbModel: SummonerDbModel?): SummonerModel? =
        summonerDbModel?.let {
            SummonerModel(
                profileIconId = summonerDbModel.profileIconId,
                name = summonerDbModel.name,
                puuid = summonerDbModel.puuid,
                summonerLevel = summonerDbModel.summonerLevel,
                revisionDate = summonerDbModel.revisionDate,
                encryptedId = summonerDbModel.encryptedId,
                encryptedAccountId = summonerDbModel.encryptedAccountId
            )
        }
}
