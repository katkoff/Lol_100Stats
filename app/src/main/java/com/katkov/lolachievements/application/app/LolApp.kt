package com.katkov.lolachievements.application.app

import android.app.Application
import androidx.room.Room
import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.module.CommonModule
import com.katkov.lolachievements.di.module.GlobalCiceroneModule
import toothpick.Toothpick

class LolApp : Application() {

    private var appDataBase: AppDataBase? = null

    override fun onCreate() {
        super.onCreate()

        initDataBase()
        initDi()
    }

    private fun initDi() {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE).apply {
            installModules(CommonModule(this@LolApp))
            installModules(GlobalCiceroneModule())
        })
    }

    private fun initDataBase() {
        appDataBase = Room.databaseBuilder(this, AppDataBase::class.java, "database")
            .allowMainThreadQueries() //????
            .build()
    }
}
