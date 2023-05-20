package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.local.MarvelDataBase
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.remote.MarvelApiService
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.Constants
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val dao: MarvelDataBase,
    private val API: MarvelApiService
) : IMarvelRepository {

    override fun getAllCharacters() = API.fetchCharacters(25)
    override fun searchCharacters(name: String) = API.searchCharacters(name)

    override fun getCharacterById(characterId: Int) =
        API.fetchCharacterById(characterId = characterId)

    override fun getComicsByCharacterId(characterId: Int) =
        API.fetchComicsByCharacterId(characterId)

    override fun getEventsByCharacterId(characterId: Int) =
        API.fetchEventsByCharacterId(characterId)

    override fun getSeriesByCharacterId(characterId: Int) =
        API.fetchSeriesByCharacterId(characterId)

    override fun getStoriesByCharacterId(characterId: Int) =
        API.fetchStoriesByCharacterId(characterId)

    override fun getAllComics() = API.fetchComics(25)
    override fun searchComics(name: String) =
        API.searchComics(name)

    override fun getComicById(comicId: Int) = API.fetchComicsById(comicId)

    override fun getCharactersByComicId(comicId: Int) =
        API.fetchCharactersByComicId(comicId)

    override fun getEventByComicId(comicId: Int) = API.fetchEventByComicId(comicId)

    override fun getStoriesByComicId(comicId: Int) = API.fetchStoriesByComicId(comicId)

    override fun getAllEvents() = API.fetchEvents(25)
    override fun searchEvents(name: String) =
        API.searchEvent(name)

    override fun getEventsById(eventId: Int) = API.fetchEventsById(eventId)

    override fun getCharactersByEventId(eventId: Int) =
        API.fetchCharactersByEventId(eventId)

    override fun getComicsByEventId(eventId: Int) = API.fetchComicsByEventId(eventId)

    override fun getSeriesByEventId(eventId: Int) = API.fetchSeriesByEventId(eventId)

    override fun getStoriesByEventId(eventId: Int) = API.fetchStoriesByEventId(eventId)
    override fun getAllSeries() = API.fetchSeries(25)

    override fun searchSeries(name: String) = API.searchSeries(name)

    override fun getSeriesById(seriesId: Int) = API.fetchSeriesById(seriesId)

    override fun getCharactersBySeriesId(seriesId: Int) =
        API.fetchCharactersBySeriesId(seriesId)

    override fun getComicsBySeriesId(seriesId: Int) = API.fetchComicsBySeriesId(seriesId)

    override fun getEventsBySeriesId(seriesId: Int) = API.fetchEventsBySeriesId(seriesId)

    override fun getStoriesBySeriesId(seriesId: Int) =
        API.fetchStoriesBySeriesId(seriesId)

    override fun getAllStories() = API.fetchStories(25)

    override fun getStoryById(storyId: Int) = API.fetchStoryById(storyId)

    override fun getCharactersByStoryId(storyId: Int) =
        API.fetchCharactersByStoryId(storyId)

    override fun getComicsByStoryId(storyId: Int) = API.fetchComicsByStoryId(storyId)

    override fun getEventsByStoryId(storyId: Int) = API.fetchEventsByStoryId(storyId)

    override fun getSeriesByStoryId(storyId: Int) = API.fetchSeriesByStoryId(storyId)


    override fun getRandomComics(): Single<List<ComicModel>> {
        return API.fetchComics(50).map { it.data?.results!! }
    }

    override fun getRandomEvents(): Single<List<EventModel>> {
        return API.fetchEvents(50).map { it.data?.results!! }
    }

    override fun getRandomSeries(): Single<List<SeriesModel>> {
        return API.fetchSeries(50).map { it.data?.results!! }
    }

    override fun getRandomCharacters(): Single<List<CharactersModel>> {
        return API.fetchCharacters(50).map { it.data?.results!! }
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
            dao.getDao().insertCharacters(characters)
            dao.getDao().insertComics(comics)
            dao.getDao().insertEvents(events)
            dao.getDao().insertSeries(series)
            listOf(
                HomeItem.Banner(Constants.MARVEL_IMAGES.shuffled().take(5)),
                HomeItem.Character(characters.shuffled().take(10)),
                HomeItem.Comics(comics.shuffled().take(10)),
                HomeItem.Events(events.shuffled().take(10)),
                HomeItem.Series(series.shuffled().take(10)),
            )
        }.onErrorResumeNext {
            Single.zip(
                dao.getDao().getAllSeries(),
                dao.getDao().getAllComics(),
                dao.getDao().getAllEvents(),
                dao.getDao().getAllCharacters(),
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

    override fun saveSearchKeyword(keyword: String): Completable {
        return dao.getDao().addSearchKeyword(SearchKeywordEntity(0, keyword))
    }

}