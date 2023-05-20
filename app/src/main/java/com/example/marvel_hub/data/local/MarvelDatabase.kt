package com.example.marvel_hub.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel_hub.data.local.daos.CharactersDao
import com.example.marvel_hub.data.local.daos.ComicsDao
import com.example.marvel_hub.data.local.daos.EventsDao
import com.example.marvel_hub.data.local.daos.SeriesDao
import com.example.marvel_hub.data.local.entities.CharactersEntity
import com.example.marvel_hub.data.local.entities.ComicsEntity
import com.example.marvel_hub.data.local.entities.EventsEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity

@Database(
    entities = [CharactersEntity::class, SeriesEntity::class, EventsEntity::class, ComicsEntity::class],
    version = 1
)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun CharactersDao(): CharactersDao
    abstract fun SeriesDao(): SeriesDao
    abstract fun ComicsDao(): ComicsDao
    abstract fun EventsDao(): EventsDao

    companion object {
        private const val DATABASE_NAME = "MarvelDatabase"
        private var instance: MarvelDatabase? = null
        fun init(context: Context): MarvelDatabase {
            return instance ?: synchronized(this) {
                buildDatabase(context).also { database ->
                    instance = database
                }
            }
        }

        fun getInstance() = instance!!
        private fun buildDatabase(context: Context): MarvelDatabase {
            return Room.databaseBuilder(context, MarvelDatabase::class.java, DATABASE_NAME).build()
        }
    }
}