package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApiService {
    @GET("characters")
    fun getAllCharacters(): Single<CharactersModel>

    @GET("characters/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    @GET("characters/{characterId}/comics")
    fun getCharacterByComics(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    @GET("characters/{characterId}/events")
    fun getCharacterByEvents(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    @GET("characters/{characterId}/series")
    fun getCharacterBySeries(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    @GET("characters/{characterId}/stories")
    fun getCharacterByStories(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    // events requests
    @GET("events")
    fun getAllEvents(): Single<EventModel>

    @GET("events/{eventId}")
    fun getEventsById(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("events/{eventId}/characters")
    fun getCharactersByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("events/{eventId}/comics")
    fun getComicsByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("events/{eventId}/creators")
    fun getCreatorsByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("events/{eventId}/series")
    fun getSeriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("events/{eventId}/stories")
    fun getStoriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    // series requests
    @GET("series")
    fun getAllSeries(): Single<SeriesModel>

    @GET("series/{seriesId}")
    fun getSeriesById(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("public/series/{seriesId}/characters")
    fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("series/{seriesId}/comics")
    fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("series/{seriesId}/creators")
    fun getCreatorsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("series/{seriesId}/events")
    fun getEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("series/{seriesId}/stories")
    fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    // stories requests
    @GET("stories")
    fun getAllStories(): Single<StoriesModel>

    @GET("stories/{storyId}")
    fun getStoryById(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("stories/{storyId}/characters")
    fun getCharactersByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("stories/{storyId}/comics")
    fun getComicsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("stories/{storyId}/creators")
    fun getCreatorsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("stories/{storyId}/events")
    fun getEventsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("stories/{storyId}/series")
    fun getSeriesByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>
}