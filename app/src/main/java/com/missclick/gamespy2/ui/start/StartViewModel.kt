package com.missclick.gamespy2.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gamespy2.App
import com.missclick.gamespy2.dataClasses.Start
import com.missclick.gamespy2.source.ISpy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StartViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
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