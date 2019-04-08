package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.SummonerDbModel
import io.reactivex.Single

@Dao
interface SummonerDao {

    @Query("SELECT COUNT(*) FROM SummonerDbModel")
    fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(summonerDbModel: SummonerDbModel)

    @Query("SELECT * FROM SummonerDbModel")
    fun getAll(): Single<SummonerDbModel>

    @Update
    fun update(summonerDbModel: SummonerDbModel)

    @Delete
    fun delete(summonerDbModel: SummonerDbModel)
}
