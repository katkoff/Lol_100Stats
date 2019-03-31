package com.katkov.lolachievements.di.module

import com.katkov.lolachievements.di.annotations.GlobalNavigationHolder
import com.katkov.lolachievements.di.annotations.GlobalRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class GlobalCiceroneModule : Module() {

    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java)
            .withName(GlobalRouter::class.java)
            .toInstance(cicerone.router)
        bind(NavigatorHolder::class.java)
            .withName(GlobalNavigationHolder::class.java)
            .toInstance(cicerone.navigatorHolder)
    }
}
