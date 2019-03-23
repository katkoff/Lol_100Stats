package com.katkov.lolachievements.data.cloud.api

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryDTOApiModel
import com.katkov.lolachievements.data.cloud.model.SummonerDTOApiModel
import com.katkov.lolachievements.data.cloud.utils.ApiUtils

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(ApiUtils.BASE_URL + "summoner/v4/summoners/by-name/{summoner_name}")
    fun getSummonerDTO(
            @Path("summoner_name") summonerName: String,
            @Query("api_key") apiKey: String
    ): Single<SummonerDTOApiModel>

    @GET(ApiUtils.BASE_URL + "champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}")
    fun getChampionsMasteryDTO(
            @Path("encryptedSummonerId") encryptedSummonerId: String,
            @Query("api_key") apiKey: String
    ): Single<List<ChampionMasteryDTOApiModel>>
}
