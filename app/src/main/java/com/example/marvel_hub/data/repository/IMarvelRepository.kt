package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.home.util.HomeItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<BaseResponse<CharactersModel>>
    fun searchCharacters(name: String): Single<BaseResponse<CharactersModel>>
    fun getCharacterById(characterId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsByCharacterId(characterId: Int): Single<BaseResponse<ComicModel>>
    fun getEventsByCharacterId(characterId: Int): Single<BaseResponse<EventModel>>
    fun getSeriesByCharacterId(characterId: Int): Single<BaseResponse<SeriesModel>>
    fun getStoriesByCharacterId(characterId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllComics(): Single<BaseResponse<ComicModel>>
    fun searchComics(name: String): Single<BaseResponse<ComicModel>>
    fun getComicById(comicId: Int): Single<BaseResponse<ComicModel>>
    fun getCharactersByComicId(comicId: Int): Single<BaseResponse<CharactersModel>>
    fun getEventByComicId(comicId: Int): Single<BaseResponse<EventModel>>
    fun getStoriesByComicId(comicId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllEvents(): Single<BaseResponse<EventModel>>
    fun searchEvents(name: String): Single<BaseResponse<EventModel>>
    fun getEventsById(eventId: Int): Single<BaseResponse<EventModel>>
    fun getCharactersByEventId(eventId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsByEventId(eventId: Int): Single<BaseResponse<ComicModel>>
    fun getSeriesByEventId(eventId: Int): Single<BaseResponse<SeriesModel>>
    fun getStoriesByEventId(eventId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllSeries(): Single<BaseResponse<SeriesModel>>
    fun searchSeries(name: String): Single<BaseResponse<SeriesModel>>

    fun getSeriesById(seriesId: Int): Single<BaseResponse<SeriesModel>>
    fun getCharactersBySeriesId(seriesId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsBySeriesId(seriesId: Int): Single<BaseResponse<ComicModel>>
    fun getEventsBySeriesId(seriesId: Int): Single<BaseResponse<EventModel>>
    fun getStoriesBySeriesId(seriesId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllStories(): Single<BaseResponse<StoriesModel>>
    fun getStoryById(storyId: Int): Single<BaseResponse<StoriesModel>>
    fun getCharactersByStoryId(storyId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsByStoryId(storyId: Int): Single<BaseResponse<ComicModel>>
    fun getEventsByStoryId(storyId: Int): Single<BaseResponse<EventModel>>
    fun getSeriesByStoryId(storyId: Int): Single<BaseResponse<SeriesModel>>


    fun getRandomComics(): Single<List<ComicModel>>
    fun getRandomEvents(): Single<List<EventModel>>
    fun getRandomSeries(): Single<List<SeriesModel>>
    fun getRandomCharacters(): Single<List<CharactersModel>>
    fun fetchHomeItems(): Single<List<HomeItem>>

    fun saveSearchKeyword(keyword: String, type: String): Completable
    fun getSearchWithKeyword(keyword: String, type: String): Observable<List<SearchKeywordEntity>>

    fun addSearchComics(comics: List<ComicEntity>): Completable
    fun getLocalSearchComics(name: String, type: String): List<ComicEntity>

    fun addSearchCharacters(character: List<CharacterEntity>): Completable
    fun getLocalSearchCharacters(name: String, type: String): List<CharacterEntity>

    fun addSearchEvents(event: List<EventEntity>): Completable
    fun getLocalSearchEvents(name: String, type: String): List<EventEntity>

    fun addSearchSeries(series: List<SeriesEntity>): Completable
    fun getLocalSearchSeries(name: String, type: String): List<SeriesEntity>
}