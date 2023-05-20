package com.example.marvel_hub.di

import com.example.marvel_hub.data.mapper.CharactersMapper
import com.example.marvel_hub.data.mapper.ComicsMapper
import com.example.marvel_hub.data.mapper.EventsMapper
import com.example.marvel_hub.data.mapper.SeriesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideComicsMapper(): ComicsMapper = ComicsMapper()

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharactersMapper = CharactersMapper()

    @Singleton
    @Provides
    fun provideEventsMapper(): EventsMapper = EventsMapper()

    @Singleton
    @Provides
    fun provideSeriesMapper(): SeriesMapper = SeriesMapper()
}