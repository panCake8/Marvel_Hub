package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.model.base.BaseResponse
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<CharactersModel>

    fun getCharacterById(characterId: Int): Single<CharactersModel>
    fun getCharacterByComics(characterId: Int): Single<CharactersModel>
    fun getCharacterByEvents(characterId: Int): Single<CharactersModel>
    fun getCharacterBySeries(characterId: Int): Single<CharactersModel>
    fun getCharacterByStories(characterId: Int): Single<CharactersModel>

    fun getAllEvents(): Single<BaseResponse<EventModel>>

    fun getEventsById(eventId: Int): Single<BaseResponse<EventModel>>

    fun getCharactersByEventId(eventId: Int): Single<BaseResponse<CharactersModel>>

    fun getComicsByEventId(eventId: Int): Single<BaseResponse<ComicModel>>

    fun getCreatorsByEventId(eventId: Int): Single<BaseResponse<CreatorModel>>

    fun getSeriesByEventId(eventId: Int): Single<BaseResponse<SeriesModel>>

    fun getStoriesByEventId(eventId: Int): Single<BaseResponse<StoriesModel>>

    fun getAllSeries(): Single<BaseResponse<SeriesModel>>

    fun getSeriesById(seriesId: Int): Single<BaseResponse<SeriesModel>>

    fun getCharactersBySeriesId(seriesId: Int): Single<BaseResponse<CharactersModel>>

    fun getComicsBySeriesId(seriesId: Int): Single<BaseResponse<ComicModel>>

    fun getCreatorsBySeriesId(seriesId: Int): Single<BaseResponse<CreatorModel>>

    fun getEventsBySeriesId(seriesId: Int): Single<BaseResponse<EventModel>>

    fun getStoriesBySeriesId(seriesId: Int): Single<BaseResponse<StoriesModel>>

    fun getAllStories(): Single<BaseResponse<StoriesModel>>

    fun getStoryById(storyId: Int): Single<BaseResponse<StoriesModel>>

    fun getCharactersByStoryId(storyId: Int): Single<BaseResponse<CharactersModel>>

    fun getComicsByStoryId(storyId: Int): Single<BaseResponse<ComicModel>>

    fun getCreatorsByStoryId(storyId: Int): Single<BaseResponse<CreatorModel>>

    fun getEventsByStoryId(storyId: Int): Single<BaseResponse<EventModel>>

    fun getSeriesByStoryId(storyId: Int): Single<BaseResponse<SeriesModel>>

}