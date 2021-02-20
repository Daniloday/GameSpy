package com.missclick.gamespy2.source

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dbs")
data class Entity(
        @PrimaryKey(autoGenerate = true)
        @NonNull
        @ColumnInfo(name = "idi")
        var idi : Int,

        @ColumnInfo(name = "Player")
        var player : String,
        )
