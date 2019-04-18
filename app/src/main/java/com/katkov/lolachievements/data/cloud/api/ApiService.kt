package com.katkov.lolachievements.data.cloud.api

import com.katkov.lolachievements.data.cloud.model.ChampionApiModel
import com.katkov.lolachievements.data.cloud.model.MatchlistApiModel
import com.katkov.lolachievements.data.cloud.model.SummonerApiModel
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
    ): Single<SummonerApiModel>

    @GET(ApiUtils.BASE_URL + "champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}")
    fun getChampionApiDto(
        @Path("encryptedSummonerId") encryptedSummonerId: String,
        @Query("api_key") apiKey: String
    ): Single<List<ChampionApiModel>>

    @GET(ApiUtils.BASE_URL + "match/v4/matchlists/by-account/{encryptedAccountId}")
    fun getMatchListApiDto(
        @Path("encryptedAccountId") encryptedAccountId: String,
        @Query("api_key") apiKey: String,
        @Query("beginIndex") beginIndex: Int,
        @Query("endIndex") endIndex: Int
    ): Single<MatchlistApiModel>
}
