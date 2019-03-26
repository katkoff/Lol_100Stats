package com.katkov.lolachievements.di.module

import com.katkov.lolachievements.di.annotations.AfterLoggingHolder
import com.katkov.lolachievements.di.annotations.AfterLoggingRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AfterLoggingCiceroneModule : Module() {

    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java)
            .withName(AfterLoggingRouter::class.java)
            .toInstance(cicerone.router)
        bind(NavigatorHolder::class.java)
            .withName(AfterLoggingHolder::class.java)
            .toInstance(cicerone.navigatorHolder)
    }
}