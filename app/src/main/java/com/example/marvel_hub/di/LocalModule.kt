package com.example.marvel_hub.di

import android.content.Context
import com.example.marvel_hub.data.local.MarvelDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Singleton
    @Provides
    fun provideDao(@ApplicationContext context: Context) = MarvelDataBase.getInstance(context)
}