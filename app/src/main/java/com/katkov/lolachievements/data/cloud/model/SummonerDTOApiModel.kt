package com.katkov.lolachievements.data.cloud.model

import com.google.gson.annotations.SerializedName

data class SummonerDTOApiModel(
        @field:SerializedName("profileIconId")
        val profileIconId: Int,
        @field:SerializedName("name")
        val name: String,
        @field:SerializedName("puuid")
        val puuid: String,
        @field:SerializedName("summonerLevel")
        val summonerLevel: Long,
        @field:SerializedName("revisionDate")
        val revisionDate: Long,
        @field:SerializedName("id")
        val id: String,
        @field:SerializedName("accountId")
        val accountId: String)
