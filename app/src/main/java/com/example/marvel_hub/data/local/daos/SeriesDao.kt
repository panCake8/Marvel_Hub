package com.example.marvel_hub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.SeriesEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface SeriesDao {
    @Insert
    suspend fun addSeries(items: List<SeriesEntity>)

    @Query("Select * from SeriesEntity")
    fun getSeries(): Single<List<SeriesEntity>>
}