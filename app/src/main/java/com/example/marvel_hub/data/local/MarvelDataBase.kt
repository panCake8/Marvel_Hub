package com.example.marvel_hub.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvel_hub.data.local.dao.MarvelDao
import com.example.marvel_hub.data.local.entities.BannerEntity
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.local.entities.StoriesEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.util.InfoConverter
import com.example.marvel_hub.data.util.ThumbnailConverter

@TypeConverters(ThumbnailConverter::class, InfoConverter::class)
@Database(
    entities = [
        CharacterEntity::class,
        ComicEntity::class,
        EventEntity::class,
        SeriesEntity::class,
        StoriesEntity::class,
        SearchKeywordEntity::class,
        BannerEntity::class,
        ComicModel::class,
        CharactersModel::class,
        SeriesModel::class,
        EventModel::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class MarvelDataBase : RoomDatabase() {

    abstract fun getDao(): MarvelDao

    companion object {
        private const val DATABASE_Name = "marvelDataBase"

        @Volatile
        private var instance: MarvelDataBase? = null

        fun getInstance(context: Context): MarvelDataBase {
            return instance ?: synchronized(this) {
                buildDataBase(context).also { instance = it }
            }
        }

        private fun buildDataBase(context: Context): MarvelDataBase {
            return Room.databaseBuilder(
                context,
                MarvelDataBase::class.java,
                DATABASE_Name
            ).build()
        }
    }
}