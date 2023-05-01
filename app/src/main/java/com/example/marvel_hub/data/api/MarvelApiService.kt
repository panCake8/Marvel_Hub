package com.example.marvel_hub.data.api

import com.example.marvel_hub.data.model.CharactersModel
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
}