package com.katkov.lolachievements.data.cloud.api

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryApiDto
import com.katkov.lolachievements.data.cloud.model.MatchlistApiDto
import com.katkov.lolachievements.data.cloud.model.SummonerApiDto
import com.katkov.lolachievements.data.cloud.utils.ApiUtils

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(ApiUtils.BASE_URL + "summoner/v4/summoners/by-name/{summoner_name}")
    fun getSummonerApiDto(
            @Path("summoner_name") summonerName: String,
            @Query("api_key") apiKey: String
    ): Single<SummonerApiDto>

    @GET(ApiUtils.BASE_URL + "champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}")
    fun getChampionsMasteryApiDto(
            @Path("encryptedSummonerId") encryptedSummonerId: String,
            @Query("api_key") apiKey: String
    ): Single<List<ChampionMasteryApiDto>>

    @GET(ApiUtils.BASE_URL + "match/v4/matchlists/by-account/{encryptedAccountId}")
    fun getMatchlistApiDto(
        @Path("encryptedAccountId") encryptedAccountId: String,
        @Query("api_key") apiKey: String
    ): Single<MatchlistApiDto>
}
