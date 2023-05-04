package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.model.base.BaseModel
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<CharactersModel>

    fun getCharacterById(characterId: Int): Single<CharactersModel>
    fun getCharacterByComics(characterId: Int): Single<CharactersModel>
    fun getCharacterByEvents(characterId: Int): Single<CharactersModel>
    fun getCharacterBySeries(characterId: Int): Single<CharactersModel>
    fun getCharacterByStories(characterId: Int): Single<CharactersModel>

    fun getAllEvents(): Single<BaseModel<EventModel>>

    fun getEventsById(eventId: Int): Single<BaseModel<EventModel>>

    fun getCharactersByEventId(eventId: Int): Single<BaseModel<CharactersModel>>

    fun getComicsByEventId(eventId: Int): Single<BaseModel<ComicModel>>

    fun getCreatorsByEventId(eventId: Int): Single<BaseModel<CreatorModel>>

    fun getSeriesByEventId(eventId: Int): Single<BaseModel<SeriesModel>>

    fun getStoriesByEventId(eventId: Int): Single<BaseModel<StoriesModel>>

    fun getAllSeries(): Single<BaseModel<SeriesModel>>

    fun getSeriesById(seriesId: Int): Single<BaseModel<SeriesModel>>

    fun getCharactersBySeriesId(seriesId: Int): Single<BaseModel<CharactersModel>>

    fun getComicsBySeriesId(seriesId: Int): Single<BaseModel<ComicModel>>

    fun getCreatorsBySeriesId(seriesId: Int): Single<BaseModel<CreatorModel>>

    fun getEventsBySeriesId(seriesId: Int): Single<BaseModel<EventModel>>

    fun getStoriesBySeriesId(seriesId: Int): Single<BaseModel<StoriesModel>>

    fun getAllStories(): Single<BaseModel<StoriesModel>>

    fun getStoryById(storyId: Int): Single<BaseModel<StoriesModel>>

    fun getCharactersByStoryId(storyId: Int): Single<BaseModel<CharactersModel>>

    fun getComicsByStoryId(storyId: Int): Single<BaseModel<ComicModel>>

    fun getCreatorsByStoryId(storyId: Int): Single<BaseModel<CreatorModel>>

    fun getEventsByStoryId(storyId: Int): Single<BaseModel<EventModel>>

    fun getSeriesByStoryId(storyId: Int): Single<BaseModel<SeriesModel>>

}