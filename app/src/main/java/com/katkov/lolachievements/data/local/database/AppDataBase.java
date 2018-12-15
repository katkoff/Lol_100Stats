package com.katkov.lolachievements.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.katkov.lolachievements.data.local.entity.Summoner;
import com.katkov.lolachievements.data.local.dao.SummonerDao;

@Database(entities = {Summoner.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract SummonerDao summonerDao();
}
