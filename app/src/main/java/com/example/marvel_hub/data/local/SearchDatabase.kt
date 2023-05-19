package com.example.marvel_hub.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.marvel_hub.data.local.daos.SearchResultDao
import com.example.marvel_hub.data.local.entity.SearchResultEntity

@Database(entities = [SearchResultEntity::class], version = 1)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun searchResultDao(): SearchResultDao

    companion object {
        private const val DATABASE_NAME = "SearchDatabase"
        private var instance: SearchDatabase? = null
        fun init(context: Context): SearchDatabase {
            return instance ?: synchronized(this) {
                buildDatabase(context).also { database ->
                    instance = database
                }
            }
        }

        fun getInstance() = instance!!
        private fun buildDatabase(context: Context): SearchDatabase {
            return Room.databaseBuilder(context, SearchDatabase::class.java, DATABASE_NAME).build()
        }


    }

}