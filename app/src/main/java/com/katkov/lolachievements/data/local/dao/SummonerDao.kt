package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.Summoner
import io.reactivex.Single

@Dao
interface SummonerDao {

    @get:Query("SELECT * from summoner")
    val all: Single<Summoner>

    @Insert
    fun insert(summoner: Summoner)

    @Update
    fun update(summoner: Summoner)

    @Delete
    fun delete(summoner: Summoner)
}
