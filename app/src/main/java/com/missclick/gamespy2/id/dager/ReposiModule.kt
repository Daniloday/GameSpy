package com.missclick.gamespy2.id.dager

import android.content.Context
import androidx.room.Room
import com.missclick.gamespy2.source.Database
import com.missclick.gamespy2.source.ISpy
import com.missclick.gamespy2.source.Lc
import com.missclick.gamespy2.source.Spy
import dagger.Module
import dagger.Provides

@Module
class ReposiModule {
    @Provides
    fun provOne(lc : Lc) : ISpy {
        return Spy(lc)
    }

    @Provides
    fun provTwo(appContext: Context) : Lc{
        val dbs = Room.databaseBuilder(appContext, Database::class.java, "dbs")
            .fallbackToDestructiveMigration()
            .build()
        return Lc(db = dbs)
    }

}