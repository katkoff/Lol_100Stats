package com.katkov.lolachievements.application.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.katkov.lolachievements.di.Scopes
import com.katkov.lolachievements.di.module.AppDataBaseModule
import com.katkov.lolachievements.di.module.CommonModule
import com.katkov.lolachievements.di.module.GlobalCiceroneModule
import toothpick.Toothpick

class LolApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initDi()
        initStetho()
        initThreeTenAbp()
    }

    private fun initDi() {
        Toothpick.inject(this, Toothpick.openScope(Scopes.APP_SCOPE).apply {
            installModules(CommonModule(this@LolApp))
            installModules(AppDataBaseModule(this@LolApp))
            installModules(GlobalCiceroneModule())
        })
    }

    private fun initStetho() = Stetho.initializeWithDefaults(this)

    private fun initThreeTenAbp() = AndroidThreeTen.init(this)
}
