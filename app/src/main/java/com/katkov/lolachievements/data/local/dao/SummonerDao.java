package com.katkov.lolachievements.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.katkov.lolachievements.data.local.model.Summoner;

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
