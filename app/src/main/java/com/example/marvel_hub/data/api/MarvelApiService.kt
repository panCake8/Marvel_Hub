package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {
    @GET("characters")
    fun getAllCharacters(): Single<BaseResponse<CharactersModel>>

    @GET("characters/{characterId}")
    fun getCharacterById(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<CharactersModel>>

    @GET("characters/{characterId}/comics")
    fun getComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<ComicModel>>

    @GET("characters/{characterId}/events")
    fun getEventsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<EventModel>>

    @GET("characters/{characterId}/series")
    fun getSeriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<SeriesModel>>

    @GET("characters/{characterId}/stories")
    fun getStoriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<StoriesModel>>

// ===================== comic  ============================================

    @GET("comics")
    fun getAllComics(): Single<BaseResponse<ComicModel>>

    @GET("comics")
    fun searchComics(
        @Query("titleStartsWith") titleStartsWith: String,
    ): Single<BaseResponse<ComicModel>>

    @GET("comics/{comicId}")
    fun getComicsById(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<ComicModel>>

    @GET("comics/{comicId}/characters")
    fun getCharactersByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<CharactersModel>>

    @GET("comics/{comicId}/creators")
    fun getCreatorsByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<CreatorModel>>

    @GET("comics/{comicId}/events")
    fun getEventByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<EventModel>>

    @GET("comics/{comicId}/stories")
    fun getStoriesByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<StoriesModel>>

    // ===================== creators ========================

    @GET("creators")
    fun getAllCreators(): Single<BaseResponse<CreatorModel>>

    @GET("creators/{creatorId}")
    fun getCreatorById(
        @Path("creatorId") creatorId: Int,
    ): Single<BaseResponse<CreatorModel>>

    @GET("creators/{creatorId}/comics")
    fun getComicsByCreatorId(
        @Path("creatorId") creatorId: Int,
    ): Single<BaseResponse<ComicModel>>

    @GET("creators/{creatorId}/events")
    fun getEventsByCreatorId(
        @Path("creatorId") creatorId: Int,
    ): Single<BaseResponse<EventModel>>

    @GET("creators/{creatorId}/series")
    fun getSeriesByCreatorId(
        @Path("creatorId") creatorId: Int,
    ): Single<BaseResponse<SeriesModel>>

    @GET("creators/{creatorId}/stories")
    fun getStoriesByCreatorId(
        @Path("creatorId") creatorId: Int,
    ): Single<BaseResponse<StoriesModel>>


    // ===================== events ========================
    @GET("events")
    fun getAllEvents(): Single<BaseResponse<EventModel>>

    @GET("events")
    fun searchEvent(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Single<BaseResponse<EventModel>>


    @GET("events/{eventId}")
    fun getEventsById(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("events/{eventId}/characters")
    fun getCharactersByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("events/{eventId}/comics")
    fun getComicsByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("events/{eventId}/creators")
    fun getCreatorsByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<CreatorModel>>

    @GET("events/{eventId}/series")
    fun getSeriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<SeriesModel>>

    @GET("events/{eventId}/stories")
    fun getStoriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<StoriesModel>>

    //===================== series =======================
    @GET("series")
    fun getAllSeries(): Single<BaseResponse<SeriesModel>>

    @GET("creators")
    fun searchSeries(
        @Query("titleStartsWith") nameStartsWith: String,
    ): Single<BaseResponse<CreatorModel>>

    @GET("series/{seriesId}")
    fun getSeriesById(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<SeriesModel>>

    @GET("series/{seriesId}/characters")
    fun getCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("series/{seriesId}/comics")
    fun getComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("series/{seriesId}/creators")
    fun getCreatorsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<CreatorModel>>

    @GET("series/{seriesId}/events")
    fun getEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("series/{seriesId}/stories")
    fun getStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<StoriesModel>>

    //======================== stories ========================
    @GET("stories")
    fun getAllStories(): Single<BaseResponse<StoriesModel>>

    @GET("stories/{storyId}")
    fun getStoryById(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<StoriesModel>>

    @GET("stories/{storyId}/characters")
    fun getCharactersByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("stories/{storyId}/comics")
    fun getComicsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("stories/{storyId}/creators")
    fun getCreatorsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<CreatorModel>>

    @GET("stories/{storyId}/events")
    fun getEventsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("stories/{storyId}/series")
    fun getSeriesByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<SeriesModel>>
}