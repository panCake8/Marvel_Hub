package com.example.marvel_hub.data.remote

import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiService {
    @GET("characters")
    fun fetchCharacters(
        @Query("limit") limit: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("characters")
    fun searchCharacters(
        @Query("nameStartsWith") nameStartsWith: String
    ): Single<BaseResponse<CharactersModel>>

    @GET("characters/{characterId}")
    fun fetchCharacterById(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<CharactersModel>>

    @GET("characters/{characterId}/comics")
    fun fetchComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<ComicModel>>

    @GET("characters/{characterId}/events")
    fun fetchEventsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<EventModel>>

    @GET("characters/{characterId}/series")
    fun fetchSeriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<SeriesModel>>

    @GET("characters/{characterId}/stories")
    fun fetchStoriesByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<BaseResponse<StoriesModel>>

// ===================== comic  ============================================

    @GET("comics")
    fun fetchComics(
        @Query("limit") limit: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("comics")
    fun searchComics(
        @Query("titleStartsWith") titleStartsWith: String,
    ): Single<BaseResponse<ComicModel>>

    @GET("comics/{comicId}")
    fun fetchComicsById(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<ComicModel>>

    @GET("comics/{comicId}/characters")
    fun fetchCharactersByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<CharactersModel>>

    @GET("comics/{comicId}/events")
    fun fetchEventByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<EventModel>>

    @GET("comics/{comicId}/stories")
    fun fetchStoriesByComicId(
        @Path("comicId") comicId: Int,
    ): Single<BaseResponse<StoriesModel>>

    // ===================== creators ========================


    // ===================== events ========================
    @GET("events")
    fun fetchEvents(
        @Query("limit") limit: Int
    ): Single<BaseResponse<EventModel>>

    @GET("events")
    fun searchEvent(
        @Query("nameStartsWith") nameStartsWith: String,
    ): Single<BaseResponse<EventModel>>


    @GET("events/{eventId}")
    fun fetchEventsById(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("events/{eventId}/characters")
    fun fetchCharactersByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("events/{eventId}/comics")
    fun fetchComicsByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("events/{eventId}/series")
    fun fetchSeriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<SeriesModel>>

    @GET("events/{eventId}/stories")
    fun fetchStoriesByEventId(
        @Path("eventId") eventId: Int
    ): Single<BaseResponse<StoriesModel>>

    //===================== series =======================
    @GET("series")
    fun fetchSeries(
        @Query("limit") limit: Int
    ): Single<BaseResponse<SeriesModel>>

    @GET("series")
    fun searchSeries(
        @Query("titleStartsWith") nameStartsWith: String,
    ): Single<BaseResponse<SeriesModel>>

    @GET("series/{seriesId}")
    fun fetchSeriesById(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<SeriesModel>>

    @GET("series/{seriesId}/characters")
    fun fetchCharactersBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("series/{seriesId}/comics")
    fun fetchComicsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("series/{seriesId}/events")
    fun fetchEventsBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("series/{seriesId}/stories")
    fun fetchStoriesBySeriesId(
        @Path("seriesId") seriesId: Int
    ): Single<BaseResponse<StoriesModel>>

    //======================== stories ========================
    @GET("stories")
    fun fetchStories(
        @Query("limit") limit: Int
    ): Single<BaseResponse<StoriesModel>>

    @GET("stories/{storyId}")
    fun fetchStoryById(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<StoriesModel>>

    @GET("stories/{storyId}/characters")
    fun fetchCharactersByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<CharactersModel>>

    @GET("stories/{storyId}/comics")
    fun fetchComicsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<ComicModel>>

    @GET("stories/{storyId}/events")
    fun fetchEventsByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<EventModel>>

    @GET("stories/{storyId}/series")
    fun fetchSeriesByStoryId(
        @Path("storyId") storyId: Int
    ): Single<BaseResponse<SeriesModel>>
}