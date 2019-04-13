package com.katkov.lolachievements.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.katkov.lolachievements.data.local.converter.MatchReferenceListConverter
import com.katkov.lolachievements.data.local.dao.ChampionDao
import com.katkov.lolachievements.data.local.dao.MatchesDao
import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import com.katkov.lolachievements.data.local.model.MatchlistDbModel
import com.katkov.lolachievements.data.local.model.SummonerDbModel

@Database(
    entities = [
        SummonerDbModel::class,
        ChampionDbModel::class,
        MatchlistDbModel::class],
    version = 1)
@TypeConverters(MatchReferenceListConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun summonerDao(): SummonerDao
    abstract fun ChampionDao(): ChampionDao
    abstract fun matchesDao(): MatchesDao
}
