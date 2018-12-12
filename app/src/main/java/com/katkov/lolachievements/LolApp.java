package com.katkov.lolachievements;

import android.app.Application;

import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.MainUseCase;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;

public class LolApp extends Application {
    public static LolApp INSTANCE;
    private Cicerone<Router> cicerone;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        initDi();
        initCicerone();
    }

    private void initDi() {
        Scope appScope = Toothpick.openScope(Scopes.APP_SCOPE);
        appScope.installModules(new Module() {{
            bind(MainUseCase.class);
        }});
        Toothpick.inject(this, appScope);
    }

    private void initCicerone() {
        cicerone = Cicerone.create();
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }
}
