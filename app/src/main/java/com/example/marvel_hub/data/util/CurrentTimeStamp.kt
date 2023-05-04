package com.example.marvel_hub.data.util

import java.sql.Timestamp

class CurrentTimeStamp {
    fun now() = Timestamp(System.currentTimeMillis()).time.toString()

}