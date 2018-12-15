package com.katkov.lolachievements.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.katkov.lolachievements.data.local.entity.Summoner;

import io.reactivex.Single;

@Dao
public interface SummonerDao {

    @Insert
    void insert(Summoner summoner);

    @Update
    void update(Summoner summoner);

    @Delete
    void delete(Summoner summoner);

    @Query("SELECT * FROM summoner")
    Single<Summoner> getAll();
}
