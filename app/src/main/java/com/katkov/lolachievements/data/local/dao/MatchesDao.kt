package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.MatchlistDbModel
import io.reactivex.Single

@Dao
interface MatchesDao {

    @Query("SELECT COUNT(*) FROM MatchlistDbModel")
    fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(matchlistDbModel: MatchlistDbModel)

    @Query("SELECT * FROM MatchlistDbModel")
    fun getMatches(): Single<MatchlistDbModel>

    @Update
    fun update(matchlistDbModel: MatchlistDbModel)

    @Query("DELETE FROM MatchlistDbModel")
    fun removeTable()
}
