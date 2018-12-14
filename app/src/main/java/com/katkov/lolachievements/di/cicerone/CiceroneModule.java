package com.katkov.lolachievements.di.cicerone;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import toothpick.config.Module;

public class CiceroneModule extends Module {

    public CiceroneModule() {
        Cicerone<Router> cicerone = Cicerone.create();
        bind(Router.class).toInstance(cicerone.getRouter());
        bind(NavigatorHolder.class).toInstance(cicerone.getNavigatorHolder());
    }
}
