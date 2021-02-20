package com.missclick.gamespy2.source

import com.missclick.gamespy2.dataClasses.Start

interface ISpy {
    fun appendData(data : Start):String
}