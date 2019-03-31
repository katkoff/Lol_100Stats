package com.katkov.lolachievements.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.model.Summoner

@Database(entities = [Summoner::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun summonerDao(): SummonerDao
}
