package com.example.marvel_hub.di

import com.example.marvel_hub.data.local.MarvelDataBase
import com.example.marvel_hub.data.remote.MarvelApiService
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.data.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(dao: MarvelDataBase, api: MarvelApiService): IMarvelRepository =
        MarvelRepository(dao, api)

}