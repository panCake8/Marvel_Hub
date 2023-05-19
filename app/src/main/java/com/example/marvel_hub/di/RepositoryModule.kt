package com.example.marvel_hub.di

import com.example.marvel_hub.data.remote.api.MarvelApiService
import com.example.marvel_hub.data.repository.MarvelRepository
import com.example.marvel_hub.domain.repository.IMarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(apiService: MarvelApiService):IMarvelRepository{
        return MarvelRepository( apiService)
    }
}