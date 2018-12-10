package com.katkov.lolachievements;

import android.app.Application;

import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.domain.usecase.MainUseCase;

import javax.inject.Singleton;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;

public class LolApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initDi();
    }

    private void initDi() {
        Scope appScope = Toothpick.openScope(Scopes.APP_SCOPE);
        appScope.installModules(new Module() {{
            bind(MainUseCase.class);
        }});
        Toothpick.inject(this, appScope);
    }
}
