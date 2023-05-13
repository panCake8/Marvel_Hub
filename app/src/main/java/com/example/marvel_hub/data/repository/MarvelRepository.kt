package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.api.API
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.Constants
import io.reactivex.rxjava3.core.Single

class MarvelRepository : IMarvelRepository {
    override fun getAllCharacters() = API.apiService.fetchCharacters(25)
    override fun searchCharacters(name: String) = API.apiService.searchCharacters(name)

    override fun getCharacterById(characterId: Int) =
        API.apiService.fetchCharacterById(characterId = characterId)

    override fun getComicsByCharacterId(characterId: Int) =
        API.apiService.fetchComicsByCharacterId(characterId)

    override fun getEventsByCharacterId(characterId: Int) =
        API.apiService.fetchEventsByCharacterId(characterId)

    override fun getSeriesByCharacterId(characterId: Int) =
        API.apiService.fetchSeriesByCharacterId(characterId)

    override fun getStoriesByCharacterId(characterId: Int) =
        API.apiService.fetchStoriesByCharacterId(characterId)

    override fun getAllComics() = API.apiService.fetchComics(25)
    override fun searchComics(name: String) =
        API.apiService.searchComics(name)

    override fun getComicById(comicId: Int) = API.apiService.fetchComicsById(comicId)

    override fun getCharactersByComicId(comicId: Int) =
        API.apiService.fetchCharactersByComicId(comicId)

    override fun getEventByComicId(comicId: Int) = API.apiService.fetchEventByComicId(comicId)

    override fun getStoriesByComicId(comicId: Int) = API.apiService.fetchStoriesByComicId(comicId)

    override fun getAllEvents() = API.apiService.fetchEvents(25)
    override fun searchEvents(name: String) =
        API.apiService.searchEvent(name)

    override fun getEventsById(eventId: Int) = API.apiService.fetchEventsById(eventId)

    override fun getCharactersByEventId(eventId: Int) =
        API.apiService.fetchCharactersByEventId(eventId)

    override fun getComicsByEventId(eventId: Int) = API.apiService.fetchComicsByEventId(eventId)

    override fun getSeriesByEventId(eventId: Int) = API.apiService.fetchSeriesByEventId(eventId)

    override fun getStoriesByEventId(eventId: Int) = API.apiService.fetchStoriesByEventId(eventId)
    override fun getAllSeries() = API.apiService.fetchSeries(25)

    override fun searchSeries(name: String) = API.apiService.searchSeries(name)

    override fun getSeriesById(seriesId: Int) = API.apiService.fetchSeriesById(seriesId)

    override fun getCharactersBySeriesId(seriesId: Int) =
        API.apiService.fetchCharactersBySeriesId(seriesId)

    override fun getComicsBySeriesId(seriesId: Int) = API.apiService.fetchComicsBySeriesId(seriesId)

    override fun getEventsBySeriesId(seriesId: Int) = API.apiService.fetchEventsBySeriesId(seriesId)

    override fun getStoriesBySeriesId(seriesId: Int) =
        API.apiService.fetchStoriesBySeriesId(seriesId)

    override fun getAllStories() = API.apiService.fetchStories(25)

    override fun getStoryById(storyId: Int) = API.apiService.fetchStoryById(storyId)

    override fun getCharactersByStoryId(storyId: Int) =
        API.apiService.fetchCharactersByStoryId(storyId)

    override fun getComicsByStoryId(storyId: Int) = API.apiService.fetchComicsByStoryId(storyId)

    override fun getEventsByStoryId(storyId: Int) = API.apiService.fetchEventsByStoryId(storyId)

    override fun getSeriesByStoryId(storyId: Int) = API.apiService.fetchSeriesByStoryId(storyId)


    override fun getRandomComics(): Single<List<ComicModel>> {
        return API.apiService.fetchComics(50).map { it.data?.results!! }
    }

    override fun getRandomEvents(): Single<List<EventModel>> {
        return API.apiService.fetchEvents(50).map { it.data?.results!! }
    }

    override fun getRandomSeries(): Single<List<SeriesModel>> {
        return API.apiService.fetchSeries(50).map { it.data?.results!! }
    }

    override fun getRandomCharacters(): Single<List<CharactersModel>> {
        return API.apiService.fetchCharacters(50).map { it.data?.results!! }
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