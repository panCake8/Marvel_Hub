package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.remote.api.MarvelApiService
import com.example.marvel_hub.domain.repository.IMarvelRepository
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.Constants
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepository @Inject constructor (
    private val apiService:MarvelApiService
        ): IMarvelRepository {
    override fun getAllCharacters() = apiService.fetchCharacters(25)
    override fun searchCharacters(name: String) = apiService.searchCharacters(name)

    override fun getCharacterById(characterId: Int) =
        apiService.fetchCharacterById(characterId = characterId)

    override fun getComicsByCharacterId(characterId: Int) =
        apiService.fetchComicsByCharacterId(characterId)

    override fun getEventsByCharacterId(characterId: Int) =
        apiService.fetchEventsByCharacterId(characterId)

    override fun getSeriesByCharacterId(characterId: Int) =
        apiService.fetchSeriesByCharacterId(characterId)

    override fun getStoriesByCharacterId(characterId: Int) =
        apiService.fetchStoriesByCharacterId(characterId)

    override fun getAllComics() = apiService.fetchComics(25)
    override fun searchComics(name: String) =
        apiService.searchComics(name)

    override fun getComicById(comicId: Int) = apiService.fetchComicsById(comicId)

    override fun getCharactersByComicId(comicId: Int) =
        apiService.fetchCharactersByComicId(comicId)

    override fun getEventByComicId(comicId: Int) = apiService.fetchEventByComicId(comicId)

    override fun getStoriesByComicId(comicId: Int) = apiService.fetchStoriesByComicId(comicId)

    override fun getAllEvents() = apiService.fetchEvents(25)
    override fun searchEvents(name: String) =
        apiService.searchEvent(name)

    override fun getEventsById(eventId: Int) = apiService.fetchEventsById(eventId)

    override fun getCharactersByEventId(eventId: Int) =
        apiService.fetchCharactersByEventId(eventId)

    override fun getComicsByEventId(eventId: Int) = apiService.fetchComicsByEventId(eventId)

    override fun getSeriesByEventId(eventId: Int) = apiService.fetchSeriesByEventId(eventId)

    override fun getStoriesByEventId(eventId: Int) = apiService.fetchStoriesByEventId(eventId)
    override fun getAllSeries() = apiService.fetchSeries(25)

    override fun searchSeries(name: String) = apiService.searchSeries(name)

    override fun getSeriesById(seriesId: Int) = apiService.fetchSeriesById(seriesId)

    override fun getCharactersBySeriesId(seriesId: Int) =
        apiService.fetchCharactersBySeriesId(seriesId)

    override fun getComicsBySeriesId(seriesId: Int) = apiService.fetchComicsBySeriesId(seriesId)

    override fun getEventsBySeriesId(seriesId: Int) = apiService.fetchEventsBySeriesId(seriesId)

    override fun getStoriesBySeriesId(seriesId: Int) =
        apiService.fetchStoriesBySeriesId(seriesId)

    override fun getAllStories() = apiService.fetchStories(25)

    override fun getStoryById(storyId: Int) = apiService.fetchStoryById(storyId)

    override fun getCharactersByStoryId(storyId: Int) =
        apiService.fetchCharactersByStoryId(storyId)

    override fun getComicsByStoryId(storyId: Int) = apiService.fetchComicsByStoryId(storyId)

    override fun getEventsByStoryId(storyId: Int) = apiService.fetchEventsByStoryId(storyId)

    override fun getSeriesByStoryId(storyId: Int) = apiService.fetchSeriesByStoryId(storyId)


    override fun getRandomComics(): Single<List<ComicModel>> {
        return apiService.fetchComics(50).map { it.data?.results!! }
    }

    override fun getRandomEvents(): Single<List<EventModel>> {
        return apiService.fetchEvents(50).map { it.data?.results!! }
    }

    override fun getRandomSeries(): Single<List<SeriesModel>> {
        return apiService.fetchSeries(50).map { it.data?.results!! }
    }

    override fun getRandomCharacters(): Single<List<CharactersModel>> {
        return apiService.fetchCharacters(50).map { it.data?.results!! }
    }

    override fun fetchHomeItems(): Single<List<HomeItem>> {
        return Single.zip(
            getRandomSeries(),
            getRandomComics(),
            getRandomEvents(),
            getRandomCharacters(),
        ) { series: List<SeriesModel>,
            comics: List<ComicModel>,
            events: List<EventModel>,
            characters: List<CharactersModel> ->
            listOf(
                HomeItem.Banner(Constants.MARVEL_IMAGES.shuffled().take(5)),
                HomeItem.Character(characters.shuffled().take(10)),
                HomeItem.Comics(comics.shuffled().take(10)),
                HomeItem.Events(events.shuffled().take(10)),
                HomeItem.Series(series.shuffled().take(10)),
            )
        }
    }

}