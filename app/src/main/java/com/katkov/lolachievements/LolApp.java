package com.katkov.lolachievements;

import android.app.Application;
import androidx.room.Room;

import com.katkov.lolachievements.data.local.database.AppDataBase;
import com.katkov.lolachievements.di.Scopes;
import com.katkov.lolachievements.di.module.CommonModule;
import com.katkov.lolachievements.di.module.CiceroneModule;

import toothpick.Scope;
import toothpick.Toothpick;

public class LolApp extends Application {

    private AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        initDataBase();
        initDi();
    }

    private void initDi() {
        Scope appScope = Toothpick.openScope(Scopes.APP_SCOPE);
        appScope.installModules(new CommonModule(this));
        appScope.installModules(new CiceroneModule());

        Toothpick.inject(this, appScope);
    }

    private void initDataBase() {
        appDataBase = Room.databaseBuilder(this, AppDataBase.class, "database")
                .allowMainThreadQueries() //????
                .build();
    }
}
