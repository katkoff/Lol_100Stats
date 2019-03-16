package com.katkov.lolachievements.data.local.dao;

import com.katkov.lolachievements.data.local.model.Summoner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Single;

@Dao
public interface SummonerDao {

    @Insert
    void insert(Summoner summoner);

    @Update
    void update(Summoner summoner);

    @Delete
    void delete(Summoner summoner);

    @Query("SELECT * from summoner")
    Single<Summoner> getAll();
}
