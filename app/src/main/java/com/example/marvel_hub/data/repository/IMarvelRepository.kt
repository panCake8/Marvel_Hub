package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import io.reactivex.rxjava3.core.Single

interface IMarvelRepository {
    fun getAllCharacters(): Single<CharactersModel>

    fun getCharacterById(characterId: Int): Single<CharactersModel>

    fun getAllEvents(): Single<EventModel>

    fun getEventsById(eventId: Int): Single<EventModel>

    fun getCharactersByEventId(eventId: Int): Single<EventModel>

    fun getComicsByEventId(eventId: Int): Single<EventModel>

    fun getCreatorsByEventId(eventId: Int): Single<EventModel>

    fun getSeriesByEventId(eventId: Int): Single<EventModel>

    fun getStoriesByEventId(eventId: Int): Single<EventModel>

    fun getAllSeries(): Single<SeriesModel>

    fun getSeriesById(seriesId: Int): Single<SeriesModel>

    fun getCharactersBySeriesId(seriesId: Int): Single<SeriesModel>

    fun getComicsBySeriesId(seriesId: Int): Single<SeriesModel>

    fun getCreatorsBySeriesId(seriesId: Int): Single<SeriesModel>

    fun getEventsBySeriesId(seriesId: Int): Single<SeriesModel>

    fun getStoriesBySeriesId(seriesId: Int): Single<SeriesModel>

    fun getAllStories(): Single<StoriesModel>

    fun getStoryById(storyId: Int): Single<StoriesModel>

    fun getCharactersByStoryId(storyId: Int): Single<StoriesModel>

    fun getComicsByStoryId(storyId: Int): Single<StoriesModel>

    fun getCreatorsByStoryId(storyId: Int): Single<StoriesModel>

    fun getEventsByStoryId(storyId: Int): Single<StoriesModel>

    fun getSeriesByStoryId(storyId: Int): Single<StoriesModel>

}