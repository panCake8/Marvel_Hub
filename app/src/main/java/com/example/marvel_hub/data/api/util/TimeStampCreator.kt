package com.example.marvel_hub.data.api.util

import java.sql.Timestamp

class TimeStampCreator {
    fun getTimeStamp(): String = Timestamp(System.currentTimeMillis()).time.toString()
}