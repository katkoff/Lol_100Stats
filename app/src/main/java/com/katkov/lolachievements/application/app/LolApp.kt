package com.katkov.lolachievements.application.app

import android.app.Application
import com.katkov.lolachievements.data.local.database.AppDataBase
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.module.AppDataBaseModule
import com.katkov.lolachievements.di.module.CommonModule
import com.katkov.lolachievements.di.module.GlobalCiceroneModule
import toothpick.Toothpick

class LolApp : Application() {

    private var appDataBase: AppDataBase? = null

    override fun onCreate() {
        super.onCreate()

        initDi()
    }

    private fun initDi() {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE).apply {
            installModules(CommonModule(this@LolApp))
            installModules(AppDataBaseModule(this@LolApp))
            installModules(GlobalCiceroneModule())
        })
    }
}
