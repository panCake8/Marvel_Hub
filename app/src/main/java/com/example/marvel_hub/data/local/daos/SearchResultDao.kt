package com.example.marvel_hub.data.local.daos

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_hub.data.local.SearchDatabase
import com.example.marvel_hub.data.local.entity.SearchResultEntity
import io.reactivex.rxjava3.core.Single

interface SearchResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchResult(items: List<SearchResultEntity>)
    @Query("Select * from SearchResultEntity")
    fun getSearchResult(): Single<List<SearchDatabase>>
}