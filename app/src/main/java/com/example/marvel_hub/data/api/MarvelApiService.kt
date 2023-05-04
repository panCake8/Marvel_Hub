package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.model.base.BaseModel
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
    fun getAllEvents(): Single<BaseModel<EventModel>>

    @GET("events/{eventId}")
    fun getEventsById(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<EventModel>>

    @GET("events/{eventId}/characters")
    fun getCharactersByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<CharactersModel>>

    @GET("events/{eventId}/comics")
    fun getComicsByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<ComicModel>>

    @GET("events/{eventId}/creators")
    fun getCreatorsByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<CreatorModel>>

    @GET("events/{eventId}/series")
    fun getSeriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<SeriesModel>>

    @GET("events/{eventId}/stories")
    fun getStoriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseModel<StoriesModel>>

    // series requests
    @GET("series")
    fun getAllSeries(): Single<BaseModel<SeriesModel>>

    @GET("series/{seriesId}")
    fun getSeriesById(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<SeriesModel>>

    @GET("series/{seriesId}/characters")
    fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<CharactersModel>>

    @GET("series/{seriesId}/comics")
    fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<ComicModel>>

    @GET("series/{seriesId}/creators")
    fun getCreatorsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<CreatorModel>>

    @GET("series/{seriesId}/events")
    fun getEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<EventModel>>

    @GET("series/{seriesId}/stories")
    fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseModel<StoriesModel>>

    // stories requests
    @GET("stories")
    fun getAllStories(): Single<BaseModel<StoriesModel>>

    @GET("stories/{storyId}")
    fun getStoryById(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<StoriesModel>>

    @GET("stories/{storyId}/characters")
    fun getCharactersByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<CharactersModel>>

    @GET("stories/{storyId}/comics")
    fun getComicsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<ComicModel>>

    @GET("stories/{storyId}/creators")
    fun getCreatorsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<CreatorModel>>

    @GET("stories/{storyId}/events")
    fun getEventsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<EventModel>>

    @GET("stories/{storyId}/series")
    fun getSeriesByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseModel<SeriesModel>>
}