package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.SummonerDbModel
import io.reactivex.Single

@Dao
interface SummonerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(summonerDbModel: SummonerDbModel)

    @Query("SELECT * FROM SummonerDbModel")
    fun getAll(): Single<SummonerDbModel>

    @Query("SELECT COUNT(*) FROM SummonerDbModel")
    fun getRowsCount(): Single<Int>

    @Update
    fun update(summonerDbModel: SummonerDbModel)

    @Delete
    fun delete(summonerDbModel: SummonerDbModel)
}
