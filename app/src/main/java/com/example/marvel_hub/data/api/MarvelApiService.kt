package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.EventModel
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

}