package com.katkov.lolachievements.di.module

import com.katkov.lolachievements.di.annotations.BottomNavigationHolder
import com.katkov.lolachievements.di.annotations.BottomNavigationRouter
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class BottomNavigationCiceroneModule : Module() {

    init {
        val cicerone = Cicerone.create()
        bind(Router::class.java)
            .withName(BottomNavigationRouter::class.java)
            .toInstance(cicerone.router)
        bind(NavigatorHolder::class.java)
            .withName(BottomNavigationHolder::class.java)
            .toInstance(cicerone.navigatorHolder)
    }
}