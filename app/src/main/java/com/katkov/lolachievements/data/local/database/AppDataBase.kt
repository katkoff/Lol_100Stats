package com.katkov.lolachievements.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.katkov.lolachievements.data.local.dao.MasteryDao
import com.katkov.lolachievements.data.local.dao.SummonerDao
import com.katkov.lolachievements.data.local.model.MasteryDbModel
import com.katkov.lolachievements.data.local.model.SummonerDbModel

@Database(entities = [SummonerDbModel::class, MasteryDbModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun summonerDao(): SummonerDao
    abstract fun masteryDao(): MasteryDao
}
