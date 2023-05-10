package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.ui.search.SearchItems
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<BaseResponse<CharactersModel>>
    fun getCharacterById(characterId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsByCharacterId(characterId: Int): Single<BaseResponse<ComicModel>>
    fun getEventsByCharacterId(characterId: Int): Single<BaseResponse<EventModel>>
    fun getSeriesByCharacterId(characterId: Int): Single<BaseResponse<SeriesModel>>
    fun getStoriesByCharacterId(characterId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllComics(): Single<BaseResponse<ComicModel>>
    fun searchComics(name: String): Single<List<ComicModel>>
    fun getComicById(comicId: Int): Single<BaseResponse<ComicModel>>
    fun getCharactersByComicId(comicId: Int): Single<BaseResponse<CharactersModel>>
    fun getCreatorsByComicId(comicId: Int): Single<BaseResponse<CreatorModel>>
    fun getEventByComicId(comicId: Int): Single<BaseResponse<EventModel>>
    fun getStoriesByComicId(comicId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllCreators(): Single<BaseResponse<CreatorModel>>

    fun getCreatorById(creatorId: Int): Single<BaseResponse<CreatorModel>>
    fun getComicsByCreatorId(creatorId: Int): Single<BaseResponse<ComicModel>>
    fun getEventsByCreatorId(creatorId: Int): Single<BaseResponse<EventModel>>
    fun getSeriesByCreatorId(creatorId: Int): Single<BaseResponse<SeriesModel>>
    fun getStoriesByCreatorId(creatorId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllEvents(): Single<BaseResponse<EventModel>>
    fun searchEvents(name: String): Single<List<EventModel>>
    fun getEventsById(eventId: Int): Single<BaseResponse<EventModel>>
    fun getCharactersByEventId(eventId: Int): Single<BaseResponse<CharactersModel>>
    fun getComicsByEventId(eventId: Int): Single<BaseResponse<ComicModel>>
    fun getCreatorsByEventId(eventId: Int): Single<BaseResponse<CreatorModel>>
    fun getSeriesByEventId(eventId: Int): Single<BaseResponse<SeriesModel>>
    fun getStoriesByEventId(eventId: Int): Single<BaseResponse<StoriesModel>>


    fun getAllSeries(): Single<BaseResponse<SeriesModel>>
    fun searchSeries(name: String): Single<List<SeriesModel>>

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
    fun fetchSearchItems(
        comicName: String,
        seriesName: String,
        eventName: String
    ): Single<List<SearchItems>>

}