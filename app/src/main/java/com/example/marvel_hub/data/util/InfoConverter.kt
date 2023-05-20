package com.example.marvel_hub.data.util

import androidx.room.TypeConverter
import com.example.marvel_hub.data.model.InfoModel
import com.example.marvel_hub.data.model.Thumbnail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class InfoConverter {
    @TypeConverter
    fun fromInfoToString(infoModel: InfoModel): String {
        return Gson().toJson(infoModel)
    }

    @TypeConverter
    fun fromStringToInfo(s: String): InfoModel {
        val type = object : TypeToken<InfoModel>() {}.type
        return Gson().fromJson(s, type)
    }
}