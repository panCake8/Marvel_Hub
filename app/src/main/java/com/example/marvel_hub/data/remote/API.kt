package com.example.marvel_hub.data.remote

import com.example.marvel_hub.data.remote.interceptor.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val loggInterceptor = HttpLoggingInterceptor().setLevel(
        HttpLoggingInterceptor.Level.BODY
    )
    private val myClient = OkHttpClient.Builder()
        .addInterceptor(loggInterceptor)
        .addInterceptor(AuthInterceptor())
        .build()

    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService: MarvelApiService = retrofit.create(MarvelApiService::class.java)
}