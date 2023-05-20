package com.example.marvel_hub.di

import com.example.marvel_hub.BuildConfig
import com.example.marvel_hub.data.remote.MarvelApiService
import com.example.marvel_hub.data.remote.interceptor.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMarvelAPI(
        client: OkHttpClient,
        converter: GsonConverterFactory,
        rxJavaAdapter: RxJava3CallAdapterFactory
    ): MarvelApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(converter)
            .addCallAdapterFactory(rxJavaAdapter)
            .build()

        return retrofit.create(MarvelApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideClint(
        interceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()

    }


    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor() = AuthInterceptor()

    @Singleton
    @Provides
    fun provideConverter() = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideRxJavaAdapter() = RxJava3CallAdapterFactory.create()
}