package com.katkov.lolachievements;

import android.app.Application;

import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.di.main.MainModule;

import toothpick.Scope;
import toothpick.Toothpick;

public class LolApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initDi();
    }

    private void initDi() {
        Scope appScope = Toothpick.openScope(Scopes.APP_SCOPE);
        appScope.installModules(new MainModule());
        Toothpick.inject(this, appScope);
    }
}
