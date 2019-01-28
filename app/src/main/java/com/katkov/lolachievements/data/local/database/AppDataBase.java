package com.katkov.lolachievements.data.local.database;

import com.katkov.lolachievements.data.local.dao.SummonerDao;
import com.katkov.lolachievements.data.local.entity.Summoner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Summoner.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract SummonerDao summonerDao();
}
