package com.missclick.gamespy2.source

import com.missclick.gamespy2.dataClasses.Start

class Spy(val l : Lc): ISpy {
    override fun appendData(data : Start): String {
        val a = l.getAsync()
        val b = l.getIdAsync(b = data.time)
        l.delAsync(a = Entity(idi = 5,player = data.players.toString()))
        l.insertAsync(a = Entity(idi = 5,player = "bob"))
        return a.toString()+b.toString()
    }
}