package com.example.marvel_hub.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.CharactersEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface CharactersDao {
    @Insert
    suspend fun addCharacters(items: List<CharactersEntity>)

    @Query("Select * from CharactersEntity")
    fun getCharacters(): Single<List<CharactersEntity>>
}