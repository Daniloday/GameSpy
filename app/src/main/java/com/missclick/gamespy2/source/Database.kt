package com.missclick.gamespy2.source

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 3)
abstract class Database : RoomDatabase(){
    abstract fun dao() : DDao
}