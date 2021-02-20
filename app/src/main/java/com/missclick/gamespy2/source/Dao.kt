package com.missclick.gamespy2.source

import androidx.room.*

@Dao
interface DDao {

    @Query("SELECT * FROM dbs")
    fun get() : List<Entity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(a: Entity)

    @Delete
    fun remove(a: Entity)

    @Query("SELECT * FROM dbs WHERE idi = :idi")
    fun getId(idi : Int) : Entity

}