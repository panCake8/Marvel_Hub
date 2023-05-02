package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApiService {
    @GET("v1/public/characters")
    fun getAllCharacters(): Single<CharactersModel>

    @GET("v1/public/characters/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Int,
    ): Single<CharactersModel>

    // events requests
    @GET("v1/public/events")
    fun getAllEvents(): Single<EventModel>

    @GET("v1/public/events/{eventId}")
    fun getEventsById(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("v1/public/events/{eventId}/characters")
    fun getCharactersByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("v1/public/events/{eventId}/comics")
    fun getComicsByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("v1/public/events/{eventId}/creators")
    fun getCreatorsByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("v1/public/events/{eventId}/series")
    fun getSeriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    @GET("v1/public/events/{eventId}/series")
    fun getStoriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<EventModel>

    // series requests
    @GET("/v1/public/series")
    fun getAllSeries(): Single<SeriesModel>

    @GET("v1/public/series/{seriesId}")
    fun getSeriesById(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("v1/public/series/{seriesId}/characters")
    fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("v1/public/series/{seriesId}/comics")
    fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("/v1/public/series/{seriesId}/creators")
    fun getCreatorsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("v1/public/series/{seriesId}/events")
    fun getEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    @GET("v1/public/series/{seriesId}/stories")
    fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<SeriesModel>

    // stories requests
    @GET("v1/public/stories")
    fun getAllStories(): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}")
    fun getStoryById(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}/characters")
    fun getCharactersByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}/comics")
    fun getComicsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}/creators")
    fun getCreatorsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}/events")
    fun getEventsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>

    @GET("v1/public/stories/{storyId}/series")
    fun getSeriesByStoryId(
        @Path("storyId") storyId: Int
    ): Single<StoriesModel>
}