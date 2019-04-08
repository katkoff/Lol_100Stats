package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.MasteryDbModel
import io.reactivex.Single

@Dao
interface MasteryDao {

    @Query("SELECT COUNT(*) FROM MasteryDbModel")
    fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(masteryDbModel: MasteryDbModel)

    @Query("SELECT * FROM MasteryDbModel")
    fun getMastery(): Single<List<MasteryDbModel>>

    @Update
    fun update(masteryDbModel: MasteryDbModel)
//
//    @Delete
//    fun delete(masteryDbModel: MasteryDbModel)
}
