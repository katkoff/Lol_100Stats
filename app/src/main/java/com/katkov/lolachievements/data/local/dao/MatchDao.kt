package com.katkov.lolachievements.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.katkov.lolachievements.data.local.model.MatchDbModel
import io.reactivex.Single

@Dao
interface MatchDao {

    @Query("SELECT COUNT(*) FROM MatchDbModel")
    fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(matchDbModel: MatchDbModel)

    @Query("SELECT * FROM MatchDbModel")
    fun getMatches(): Single<List<MatchDbModel>>

    @Query("DELETE FROM MatchDbModel")
    fun removeTable()
}
