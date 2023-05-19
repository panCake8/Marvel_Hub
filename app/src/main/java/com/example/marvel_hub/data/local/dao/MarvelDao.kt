package com.example.marvel_hub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.marvel_hub.data.local.entities.CharacterEntity
@Dao
interface MarvelDao {

    @Insert
    fun addCharacter(character: CharacterEntity)
}