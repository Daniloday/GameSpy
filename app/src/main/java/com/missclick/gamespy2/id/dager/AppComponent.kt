package com.missclick.gamespy2.id.dager

import com.missclick.gamespy2.ui.cards.CardsViewModel
import com.missclick.gamespy2.ui.last.LastViewModel
import com.missclick.gamespy2.ui.paramets.ParametrsViewModel
import com.missclick.gamespy2.ui.start.StartViewModel
import com.missclick.gamespy2.ui.time.TimeViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, ReposiModule::class])
@Singleton
interface AppComponent{
    fun inject(a : StartViewModel)
    fun inject(b : LastViewModel)
    fun inject(c : ParametrsViewModel)
    fun inject(d : TimeViewModel)
    fun inject(e : CardsViewModel)
}