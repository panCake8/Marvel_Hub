package com.example.marvel_hub.data

import com.example.marvel_hub.data.model.MarvelCharactersModel
import com.example.marvel_hub.util.Constants
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET("characters")
    fun getAllCharacters(
        @Query("apikey") apikey: String = Constants.ApiKey.apiKey
    ): Single<MarvelCharactersModel>
}