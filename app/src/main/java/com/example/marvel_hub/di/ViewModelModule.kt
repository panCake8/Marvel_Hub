package com.example.marvel_hub.di

import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.characters.CharacterViewModel
import com.example.marvel_hub.ui.comics.ComicViewModel
import com.example.marvel_hub.ui.details.character.CharacterDetailsViewModel
import com.example.marvel_hub.ui.details.comics.ComicsDetailsViewModel
import com.example.marvel_hub.ui.details.events.EventsDetailsViewModel
import com.example.marvel_hub.ui.details.series.SeriesDetailsViewModel
import com.example.marvel_hub.ui.details.stories.StoriesDetailsViewModel
import com.example.marvel_hub.ui.events.EventsViewModel
import com.example.marvel_hub.ui.home.viewModel.HomeViewModel
import com.example.marvel_hub.ui.search.SearchViewModel
import com.example.marvel_hub.ui.series.SeriesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ViewModelModule {

    @Provides
    fun provideSearchVM(repository: IMarvelRepository) = SearchViewModel(repository)

    @Provides
    fun provideHomeVM(repository: IMarvelRepository) = HomeViewModel(repository)

    @Provides
    fun provideCharactersVM(repository: IMarvelRepository) = CharacterViewModel(repository)

    @Provides
    fun provideComicVM(repository: IMarvelRepository) = ComicViewModel(repository)

    @Provides
    fun provideEventsVM(repository: IMarvelRepository) = EventsViewModel(repository)

    @Provides
    fun provideSeriesVM(repository: IMarvelRepository) = SeriesViewModel(repository)

    @Provides
    fun provideCharacterDetailsVM(repository: IMarvelRepository) =
        CharacterDetailsViewModel(repository)

    @Provides
    fun provideComicDetailsVM(repository: IMarvelRepository) = ComicsDetailsViewModel(repository)


    @Provides
    fun provideEventDetailsVM(repository: IMarvelRepository) = EventsDetailsViewModel(repository)

    @Provides
    fun provideSeriesDetailsVM(repository: IMarvelRepository) = SeriesDetailsViewModel(repository)

    @Provides
    fun provideStoriesDetailsVM(repository: IMarvelRepository) = StoriesDetailsViewModel(repository)
}
