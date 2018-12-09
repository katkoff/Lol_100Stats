package com.katkov.lolachievements;

import android.app.Application;

import com.katkov.lolachievements.di.Scopes;

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
        Toothpick.inject(this, appScope);
    }
}
