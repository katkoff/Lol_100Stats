package com.katkov.lolachievements.data.cloud.api;

import com.katkov.lolachievements.data.cloud.api.model.SummonerDTOApiModel;
import com.katkov.lolachievements.data.cloud.utils.ApiUrlUtils;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET(ApiUrlUtils.BASE_URL + "summoner/v4/summoners/by-name/{summoner_name}")
    Single<SummonerDTOApiModel> getSummonerDTO(
            @Path("summoner_name") String summonerName,
            @Query("api_key") String apiKey
    );
}
