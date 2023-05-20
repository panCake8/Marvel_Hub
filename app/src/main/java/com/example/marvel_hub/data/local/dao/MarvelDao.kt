package com.example.marvel_hub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import io.reactivex.rxjava3.core.Completable

@Dao
interface MarvelDao {

    @Insert
    fun addCharacter(character: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchKeyword(keyword: SearchKeywordEntity) : Completable
}