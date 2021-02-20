package com.missclick.gamespy2.source

import android.util.Log
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class Lc(val db : Database) {

    fun getAsync() : Deferred<List<Entity>> {
        return GlobalScope.async {
            db.dao().get()
        }
    }
    fun getIdAsync(b: Int) : Deferred<Entity> {
        return GlobalScope.async {
            db.dao().getId(idi = b)
        }
    }

    fun delAsync(a: Entity){
        GlobalScope.async {
            db.dao().remove(a = a)
        }
    }
    fun insertAsync(a: Entity){
        GlobalScope.async {
            db.dao().insert(a = a)
        }
    }

}