package com.katkov.lolachievements.data.cloud.model.match

import com.google.gson.annotations.SerializedName

data class ParticipantTimelineApiModel(
    @SerializedName("lane")
    val lane: String,
    @SerializedName("participantId")
    val participantId: Int,
    @SerializedName("csDiffPerMinDeltas")
    val csDiffPerMinDeltas: Map<String, Double>,
    @SerializedName("goldPerMinDeltas")
    val goldPerMinDeltas: Map<String, Double>,
    @SerializedName("xpDiffPerMinDeltas")
    val xpDiffPerMinDeltas: Map<String, Double>,
    @SerializedName("creepsPerMinDeltas")
    val creepsPerMinDeltas: Map<String, Double>,
    @SerializedName("xpPerMinDeltas")
    val xpPerMinDeltas: Map<String, Double>,
    @SerializedName("role")
    val role: String,
    @SerializedName("damageTakenDiffPerMinDeltas")
    val damageTakenDiffPerMinDeltas: Map<String, Double>,
    @SerializedName("damageTakenPerMinDeltas")
    val damageTakenPerMinDeltas: Map<String, Double>
)