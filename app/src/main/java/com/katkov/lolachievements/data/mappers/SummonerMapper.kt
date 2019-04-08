package com.katkov.lolachievements.data.mappers

import com.katkov.lolachievements.data.cloud.model.SummonerApiDto
import com.katkov.lolachievements.data.local.model.SummonerDbModel
import com.katkov.lolachievements.domain.model.SummonerModel

import javax.inject.Inject

class SummonerMapper
@Inject
constructor() {

    fun mapApiToDomainModel(summonerApiDto: SummonerApiDto): SummonerModel = SummonerModel(
        profileIconId = summonerApiDto.profileIconId,
        name = summonerApiDto.name,
        puuid = summonerApiDto.puuid,
        summonerLevel = summonerApiDto.summonerLevel,
        revisionDate = summonerApiDto.revisionDate,
        encryptedId = summonerApiDto.encryptedId,
        encryptedAccountId = summonerApiDto.accountId
    )

    fun mapApiToDbModel(summonerApiDto: SummonerApiDto): SummonerDbModel = SummonerDbModel(
        profileIconId = summonerApiDto.profileIconId,
        name = summonerApiDto.name,
        puuid = summonerApiDto.puuid,
        summonerLevel = summonerApiDto.summonerLevel,
        revisionDate = summonerApiDto.revisionDate,
        encryptedId = summonerApiDto.encryptedId,
        encryptedAccountId = summonerApiDto.accountId
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

    fun mapDomainToDbModel(summonerModel: SummonerModel): SummonerDbModel = SummonerDbModel(
        1,
        summonerModel.profileIconId,
        summonerModel.name,
        summonerModel.puuid,
        summonerModel.summonerLevel,
        summonerModel.revisionDate,
        summonerModel.encryptedId,
        summonerModel.encryptedAccountId
    )
}
