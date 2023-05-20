package com.example.marvel_hub.data.repository

import android.annotation.SuppressLint
import com.example.marvel_hub.data.local.MarvelDataBase
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SearchKeywordEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.mapper.CharactersMapper
import com.example.marvel_hub.data.mapper.ComicsMapper
import com.example.marvel_hub.data.mapper.EventsMapper
import com.example.marvel_hub.data.mapper.SeriesMapper
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.remote.MarvelApiService
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.Constants
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MarvelRepository @Inject constructor(
    private val dao: MarvelDataBase,
    private val API: MarvelApiService,
    private val comicsMapper: ComicsMapper,
    private val characterMapper: CharactersMapper,
    private val eventsMapper: EventsMapper,
    private val seriesMapper: SeriesMapper,
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
        return try {
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
        } catch (e: Exception) {
            Single.zip(
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
            }
            return Single.zip(
                getRandomSeries(),
                getRandomComics(),
                getRandomEvents(),
                getRandomCharacters(),
            ) { series: List<SeriesModel>, comics: List<ComicModel>, events: List<EventModel>, characters: List<CharactersModel> ->
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

    override fun saveSearchKeyword(keyword: String, type: String): Completable {
        return dao.getDao().addSearchKeyword(SearchKeywordEntity(0, keyword, type))
            .subscribeOn(Schedulers.io())
    }

    override fun getSearchWithKeyword(
        keyword: String,
        type: String
    ): Observable<List<SearchKeywordEntity>> {
        TODO("Not yet implemented")
    }

    override fun addSearchComics(comics: List<ComicEntity>): Completable {
        return dao.getDao().addSearchComics(comics)
    }

    @SuppressLint("CheckResult")
    override fun getLocalSearchComics(name: String, type: String): List<ComicEntity> {
        var comics: List<ComicEntity>? = null
        getSearchWithKeyword(name, type).subscribeOn(Schedulers.io()).subscribe { results ->
            if (results.isEmpty()) {
                searchComics(name).subscribeOn(Schedulers.io()).subscribe { data ->
                    val list = data.data?.results?.map {
                        comicsMapper.map(it)
                    }
                    dao.getDao().addSearchComics(list!!)
                    comics = list
                }
            } else {
                dao.getDao().getSearchComics().subscribeOn(Schedulers.io()).subscribe {
                    comics = it
                }
            }
        }
        return comics ?: listOf()
    }

    override fun addSearchCharacters(character: List<CharacterEntity>): Completable {
        return dao.getDao().addSearchCharacters(character)
    }

    @SuppressLint("CheckResult")
    override fun getLocalSearchCharacters(name: String, type: String): List<CharacterEntity> {
        var character: List<CharacterEntity>? = null
        getSearchWithKeyword(name, type).subscribeOn(Schedulers.io()).subscribe { results ->
            if (results.isEmpty()) {
                searchCharacters(name).subscribeOn(Schedulers.io()).subscribe { data ->
                    val list = data.data?.results?.map {
                        characterMapper.map(it)
                    }
                    dao.getDao().addSearchCharacters(list!!)
                    character = list
                }
            } else {
                dao.getDao().getSearchCharacters().subscribeOn(Schedulers.io()).subscribe {
                    character = it
                }
            }
        }
        return character ?: listOf()
    }

    override fun addSearchEvents(event: List<EventEntity>): Completable {
          return dao.getDao().addSearchEvents(event)
    }

    @SuppressLint("CheckResult")
    override fun getLocalSearchEvents(name: String, type: String): List<EventEntity> {
        var events: List<EventEntity>? = null
        getSearchWithKeyword(name, type).subscribeOn(Schedulers.io()).subscribe { results ->
            if (results.isEmpty()) {
                searchEvents(name).subscribeOn(Schedulers.io()).subscribe { data ->
                    val list = data.data?.results?.map {
                        eventsMapper.map(it)
                    }
                    dao.getDao().addSearchEvents(list!!)
                    events = list
                }
            } else {
                dao.getDao().getSearchCEvents().subscribeOn(Schedulers.io()).subscribe {
                    events = it
                }
            }
        }
        return events ?: listOf()
    }

    override fun addSearchSeries(series: List<SeriesEntity>): Completable {
        return dao.getDao().addSearchSeries(series)
    }

    @SuppressLint("CheckResult")
    override fun getLocalSearchSeries(name: String, type: String): List<SeriesEntity> {
        var series: List<SeriesEntity>? = null
        getSearchWithKeyword(name, type).subscribeOn(Schedulers.io()).subscribe { results ->
            if (results.isEmpty()) {
                searchSeries(name).subscribeOn(Schedulers.io()).subscribe { data ->
                    val list = data.data?.results?.map {
                        seriesMapper.map(it)
                    }
                    dao.getDao().addSearchSeries(list!!)
                    series = list
                }
            } else {
                dao.getDao().getSearchCSeries().subscribeOn(Schedulers.io()).subscribe {
                    series = it
                }
            }
        }
        return series ?: listOf()
    }
}