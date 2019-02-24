package com.katkov.lolachievements.data.cloud.api;

import com.katkov.lolachievements.data.cloud.model.ChampionMasteryDTOApiModel;
import com.katkov.lolachievements.data.cloud.model.SummonerDTOApiModel;
import com.katkov.lolachievements.data.cloud.utils.ApiUtils;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET(ApiUtils.BASE_URL + "summoner/v4/summoners/by-name/{summoner_name}")
    Single<SummonerDTOApiModel> getSummonerDTO(
            @Path("summoner_name") String summonerName,
            @Query("api_key") String apiKey
    );

    @GET(ApiUtils.BASE_URL + "champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}")
    Single<List<ChampionMasteryDTOApiModel>> getChampionsMasteryDTO(
            @Path("encryptedSummonerId") String encryptedSummonerId,
            @Query("api_key") String apiKey
    );
}
