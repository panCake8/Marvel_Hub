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
    override fun getAllCharacters() = API.apiService.getAllCharacters()
    override fun searchCharacters(name: String) = API.apiService.searchCharacters(name)

    override fun getCharacterById(characterId: Int) =
        API.apiService.getCharacterById(characterId = characterId)

    override fun getComicsByCharacterId(characterId: Int) =
        API.apiService.getComicsByCharacterId(characterId)

    override fun getEventsByCharacterId(characterId: Int) =
        API.apiService.getEventsByCharacterId(characterId)

    override fun getSeriesByCharacterId(characterId: Int) =
        API.apiService.getSeriesByCharacterId(characterId)

    override fun getStoriesByCharacterId(characterId: Int) =
        API.apiService.getStoriesByCharacterId(characterId)

    override fun getAllComics() = API.apiService.getAllComics()
    override fun searchComics(name: String) =
        API.apiService.searchComics(name)

    override fun getComicById(comicId: Int) = API.apiService.getComicsById(comicId)

    override fun getCharactersByComicId(comicId: Int) =
        API.apiService.getCharactersByComicId(comicId)

    override fun getEventByComicId(comicId: Int) = API.apiService.getEventByComicId(comicId)

    override fun getStoriesByComicId(comicId: Int) = API.apiService.getStoriesByComicId(comicId)

    override fun getAllEvents() = API.apiService.getAllEvents()
    override fun searchEvents(name: String) =
        API.apiService.searchEvent(name)

    override fun getEventsById(eventId: Int) = API.apiService.getEventsById(eventId)

    override fun getCharactersByEventId(eventId: Int) =
        API.apiService.getCharactersByEventId(eventId)

    override fun getComicsByEventId(eventId: Int) = API.apiService.getComicsByEventId(eventId)

    override fun getSeriesByEventId(eventId: Int) = API.apiService.getSeriesByEventId(eventId)

    override fun getStoriesByEventId(eventId: Int) = API.apiService.getStoriesByEventId(eventId)
    override fun getAllSeries() = API.apiService.getAllSeries()

    override fun searchSeries(name: String) = API.apiService.searchSeries(name)

    override fun getSeriesById(seriesId: Int) = API.apiService.getSeriesById(seriesId)

    override fun getCharactersBySeriesId(seriesId: Int) =
        API.apiService.getCharactersBySeriesId(seriesId)

    override fun getComicsBySeriesId(seriesId: Int) = API.apiService.getComicsBySeriesId(seriesId)

    override fun getEventsBySeriesId(seriesId: Int) = API.apiService.getEventsBySeriesId(seriesId)

    override fun getStoriesBySeriesId(seriesId: Int) = API.apiService.getStoriesBySeriesId(seriesId)
    override fun getAllStories() = API.apiService.getAllStories()

    override fun getStoryById(storyId: Int) = API.apiService.getStoryById(storyId)

    override fun getCharactersByStoryId(storyId: Int) =
        API.apiService.getCharactersByStoryId(storyId)

    override fun getComicsByStoryId(storyId: Int) = API.apiService.getComicsByStoryId(storyId)

    override fun getEventsByStoryId(storyId: Int) = API.apiService.getEventsByStoryId(storyId)

    override fun getSeriesByStoryId(storyId: Int) = API.apiService.getSeriesByStoryId(storyId)


    override fun getRandomComics(): Single<List<ComicModel>> {
        return API.apiService.getAllComics().map { it.data?.results!! }
    }

    override fun getRandomEvents(): Single<List<EventModel>> {
        return API.apiService.getAllEvents().map { it.data?.results!! }
    }

    override fun getRandomSeries(): Single<List<SeriesModel>> {
        return API.apiService.getAllSeries().map { it.data?.results!! }
    }

    override fun getRandomCharacters(): Single<List<CharactersModel>> {
        return API.apiService.getAllCharacters().map { it.data?.results!! }
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
                HomeItem.Series(series.shuffled().take(10)),
                HomeItem.Comics(comics.shuffled().take(10)),
                HomeItem.Events(events.shuffled().take(10)),
                HomeItem.QuizGameBanner,
                HomeItem.Banner(
                    listOf(
                        Constants.MARVEL_IMAGE_COMIC,
                        Constants.MARVEL_IMAGE_STORY,
                        Constants.MARVEL_IMAGE_THANOS,
                        Constants.MARVEL_IMAGE_DEAD_POOL,
                        Constants.MARVEL_IMAGE_SPIDER_MAN
                    ).shuffled()
                ),
                HomeItem.Character(characters.shuffled().take(10))
            )
        }
    }
}