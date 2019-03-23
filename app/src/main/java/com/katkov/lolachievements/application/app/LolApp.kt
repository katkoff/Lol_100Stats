package com.katkov.lolachievements.application.app

import android.app.Application
import androidx.room.Room
import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.module.CiceroneModule
import com.katkov.lolachievements.di.module.CommonModule
import toothpick.Toothpick

class LolApp : Application() {

    private var appDataBase: AppDataBase? = null

    override fun onCreate() {
        super.onCreate()

        initDataBase()
        initDi()
    }

    private fun initDi() {
        val appScope = Toothpick.openScope(Scopes.APP_SCOPE)
        appScope.installModules(CommonModule(this))
        appScope.installModules(CiceroneModule())

        Toothpick.inject(this, appScope)
    }

    private fun initDataBase() {
        appDataBase = Room.databaseBuilder(this, AppDataBase::class.java, "database")
                .allowMainThreadQueries() //????
                .build()
    }
}
