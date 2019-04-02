package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class SummonerApiDto(
    @SerializedName("profileIconId")
    val profileIconId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("puuid")
    val puuid: String,
    @SerializedName("summonerLevel")
    val summonerLevel: Long,
    @SerializedName("revisionDate")
    val revisionDate: Long,
    @SerializedName("id")
    val encryptedId: String,
    @SerializedName("accountId")
    val accountId: String
)
