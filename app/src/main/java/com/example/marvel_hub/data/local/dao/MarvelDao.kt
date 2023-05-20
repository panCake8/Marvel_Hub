package com.example.marvel_hub.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface MarvelDao {

    @Insert
    fun addCharacter(character: CharacterEntity)

    @Query("select * from SearchKeywordEntity where searchKeyword like :keyword and type like :type")
    fun getSearchWithKeyword(keyword: String, type: String): Observable<List<SearchKeywordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchComics(comics: List<ComicEntity>): Completable

    @Query("select * from ComicEntity")
    fun getSearchComics(): Observable<List<ComicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchCharacters(character: List<CharacterEntity>): Completable

    @Query("select * from characterentity")
    fun getSearchCharacters(): Observable<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchEvents(event: List<EventEntity>): Completable

    @Query("select * from EventEntity")
    fun getSearchCEvents(): Observable<List<EventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addSearchSeries(series: List<SeriesEntity>): Completable

    @Query("select * from SeriesEntity")
    fun getSearchCSeries(): Observable<List<SeriesEntity>>
    fun addSearchKeyword(keyword: SearchKeywordEntity): Completable


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: List<CharactersModel>): Completable

    @Query("SELECT * FROM CharactersModel")
    fun getAllCharacters(): Single<List<CharactersModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComics(comics: List<ComicModel>): Completable

    @Query("SELECT * FROM ComicModel")
    fun getAllComics(): Single<List<ComicModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(events: List<EventModel>): Completable

    @Query("SELECT * FROM EventModel")
    fun getAllEvents(): Single<List<EventModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeries(series: List<SeriesModel>): Completable

    @Query("SELECT * FROM SeriesModel")
    fun getAllSeries(): Single<List<SeriesModel>>
}