package com.katkov.lolachievements.di.module

import android.content.Context
import androidx.room.Room
import com.katkov.lolachievements.data.local.database.AppDataBase
import toothpick.config.Module

class AppDataBaseModule(context: Context) : Module() {

    init {
        val appDataBase = Room.databaseBuilder(
            context, AppDataBase::class.java, "LolDataBase")
            .allowMainThreadQueries()
            .build()

        bind(AppDataBase::class.java)
            .toInstance(appDataBase)
    }
}