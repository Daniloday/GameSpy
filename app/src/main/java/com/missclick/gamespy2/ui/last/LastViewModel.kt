package com.missclick.gamespy2.ui.last

import androidx.lifecycle.ViewModel
import com.missclick.gamespy2.App
import com.missclick.gamespy2.dataClasses.Start
import com.missclick.gamespy2.source.ISpy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LastViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    @Inject
    lateinit var spy: ISpy

    init {
        App.appComponent.inject(this)
    }
    fun safe(){
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                spy.appendData(data = Start(1,2))
            }
        }
    }
}