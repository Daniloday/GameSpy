package com.missclick.gamespy2.id.dager

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ReposiModule::class])
class AppModule(context: Context) {

    private var appContext : Context = context

    @Provides
    @Singleton
    fun provideContext() : Context {
        return appContext
    }

}