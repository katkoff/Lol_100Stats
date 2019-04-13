package com.katkov.lolachievements.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.katkov.lolachievements.domain.model.MatchReferenceModel
import java.util.*

class MatchReferenceListConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromListToString(objectList: List<MatchReferenceModel>): String {
        return gson.toJson(objectList)
    }

    @TypeConverter
    fun fromStringToList(jsonString: String?): List<MatchReferenceModel> {
        if (jsonString == null) return Collections.emptyList()
        val listType = object : TypeToken<List<MatchReferenceModel>>() {}.type
        return gson.fromJson(jsonString, listType)
    }
}