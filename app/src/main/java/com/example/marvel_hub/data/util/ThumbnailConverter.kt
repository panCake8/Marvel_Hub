package com.example.marvel_hub.data.util

import androidx.room.TypeConverter
import com.example.marvel_hub.data.model.Thumbnail
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ThumbnailConverter {
    @TypeConverter
    fun fromThumbnailToString(thumbnail: Thumbnail): String {
        return Gson().toJson(thumbnail)
    }

    @TypeConverter
    fun fromStringToThumbNail(s: String): Thumbnail {
        val type = object : TypeToken<Thumbnail>() {}.type
        return Gson().fromJson(s, type)
    }
}