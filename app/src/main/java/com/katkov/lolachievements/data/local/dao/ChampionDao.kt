package com.katkov.lolachievements.data.local.dao

import androidx.room.*
import com.katkov.lolachievements.data.local.model.ChampionDbModel
import io.reactivex.Single

@Dao
abstract class ChampionDao {

    @Query("SELECT COUNT(*) FROM ChampionDbModel")
    abstract fun getRowsCount(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(championDbModel: ChampionDbModel)

    @Query("SELECT * FROM ChampionDbModel")
    abstract fun getChampion(): Single<List<ChampionDbModel>>

    @Update
    abstract fun update(championDbModel: ChampionDbModel)

    @Transaction
    open fun insertOrUpdate(championDbModel: ChampionDbModel) {
        val mastery = getChampion(championDbModel.summonerId, championDbModel.championId)
        if (mastery == null) {
            insert(championDbModel)
        } else {
            update(championDbModel.copy(id = mastery.id))
        }
    }

    @Query("SELECT * FROM ChampionDbModel WHERE summonerId = :summonerId AND championId = :championId")
    abstract fun getChampion(summonerId: String, championId: Long): ChampionDbModel?

    @Query("DELETE FROM ChampionDbModel")
    abstract fun removeTable()
}
