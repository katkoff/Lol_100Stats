package com.katkov.lolachievements.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katkov.lolachievements.data.local.dao.ChampionDao
import com.katkov.lolachievements.data.local.dao.MatchDao
import com.katkov.lolachievements.data.local.dao.MatchReferenceDao
import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import com.katkov.lolachievements.data.local.model.MatchDbModel
import com.katkov.lolachievements.data.local.model.MatchReferenceDbModel
import com.katkov.lolachievements.data.local.model.SummonerDbModel

@Database(
    entities = [
        SummonerDbModel::class,
        ChampionDbModel::class,
        MatchReferenceDbModel::class,
        MatchDbModel::class],
    version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun summonerDao(): SummonerDao
    abstract fun championDao(): ChampionDao
    abstract fun matchReferenceDao(): MatchReferenceDao
    abstract fun matchDao(): MatchDao
}
