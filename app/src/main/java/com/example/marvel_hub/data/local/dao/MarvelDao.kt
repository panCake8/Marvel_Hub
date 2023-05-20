package com.example.marvel_hub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.BannerEntity
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.ui.home.util.HomeItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(character: CharacterEntity): Completable


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchKeyword(keyword: SearchKeywordEntity): Completable


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: List<CharacterEntity>): Completable

    @Query("SELECT * FROM CharacterEntity")
    fun getAllCharacters(): Single<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComics(comics: List<ComicEntity>): Completable

    @Query("SELECT * FROM ComicEntity")
    fun getAllComics(): Single<List<ComicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(events: List<EventEntity>): Completable

    @Query("SELECT * FROM EventEntity")
    fun getAllEvents(): Single<List<EventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(series: List<SeriesEntity>): Completable

    @Query("SELECT * FROM SeriesEntity")
    fun getAllSeries(): Single<List<SeriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBanner(series: List<BannerEntity>): Completable

    @Query("SELECT * FROM SeriesEntity")
    fun getAllBanners(): Single<List<BannerEntity>>
}