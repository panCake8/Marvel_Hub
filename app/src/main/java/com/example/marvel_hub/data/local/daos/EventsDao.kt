package com.example.marvel_hub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.EventsEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface EventsDao {
    @Insert
    suspend fun addEvents(items: List<EventsEntity>)

    @Query("Select * from EventsEntity")
    fun getEvents(): Single<List<EventsEntity>>
}