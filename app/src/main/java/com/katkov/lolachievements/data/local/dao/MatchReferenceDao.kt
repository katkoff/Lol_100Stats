package com.katkov.lolachievements.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.katkov.lolachievements.data.local.model.MatchReferenceDbModel
import io.reactivex.Single

@Dao
interface MatchReferenceDao {

    @Query("SELECT COUNT(*) FROM MatchReferenceDbModel")
    fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(matchReferenceDbModel: MatchReferenceDbModel)

    @Query("SELECT * FROM MatchReferenceDbModel")
    fun getMatches(): Single<List<MatchReferenceDbModel>>

    @Query("DELETE FROM MatchReferenceDbModel")
    fun removeTable()
}
