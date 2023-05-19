package com.example.marvel_hub.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.CharactersEntity
import com.example.marvel_hub.data.local.entities.ComicsEntity
import com.example.marvel_hub.data.local.entities.EventsEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import io.reactivex.rxjava3.core.Single

interface MarvelDao {
    @Insert
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("Select * from CharactersEntity")
    fun getCharacters(): Single<List<CharactersEntity>>

    @Insert
    suspend fun addComics(items: List<ComicsEntity>)

    @Query("Select * from ComicsEntity")
    fun getComics(): Single<List<ComicsEntity>>

    @Insert
    suspend fun addEvents(items: List<EventsEntity>)

    @Query("Select * from EventsEntity")
    fun getEvents(): Single<List<EventsEntity>>

    @Insert
    suspend fun addSeries(items: List<SeriesEntity>)

    @Query("Select * from SeriesEntity")
    fun getSeries(): Single<List<SeriesEntity>>

}