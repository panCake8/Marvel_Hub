package com.example.marvel_hub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.ComicsEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface ComicsDao {
    @Insert
    suspend fun addComics(items: List<ComicsEntity>)

    @Query("Select * from ComicsEntity")
    fun getComics(): Single<List<ComicsEntity>>
}