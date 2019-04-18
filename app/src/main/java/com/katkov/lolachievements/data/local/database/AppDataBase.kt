package com.katkov.lolachievements.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katkov.lolachievements.data.local.dao.ChampionsDao
import com.katkov.lolachievements.data.local.dao.MatchesDao
import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import com.katkov.lolachievements.data.local.model.MatchReferenceDbModel
import com.katkov.lolachievements.data.local.model.SummonerDbModel

@Database(
    entities = [
        SummonerDbModel::class,
        ChampionDbModel::class,
        MatchReferenceDbModel::class],
    version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun summonerDao(): SummonerDao
    abstract fun championsDao(): ChampionsDao
    abstract fun matchesDao(): MatchesDao
}
