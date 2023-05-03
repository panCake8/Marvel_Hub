package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.api.API
import com.example.marvel_hub.data.model.CharactersModel
import io.reactivex.rxjava3.core.Single

class MarvelRepository : IMarvelRepository {
    override fun getAllCharacters() = API.apiService.getAllCharacters()

    override fun getCharacterById(characterId: Int) =
        API.apiService.getCharacterById(characterId = characterId)

    override fun getCharacterByComics(characterId: Int): Single<CharactersModel> =
        API.apiService.getCharacterByComics(characterId)

    override fun getCharacterByEvents(characterId: Int): Single<CharactersModel> =
        API.apiService.getCharacterByEvents(characterId)

    override fun getCharacterBySeries(characterId: Int): Single<CharactersModel> =
        API.apiService.getCharacterBySeries(characterId)

    override fun getCharacterByStories(characterId: Int): Single<CharactersModel> =
        API.apiService.getCharacterByStories(characterId)

    override fun getAllEvents() = API.apiService.getAllEvents()

    override fun getEventsById(eventId: Int) = API.apiService.getEventsById(eventId)

    override fun getCharactersByEventId(eventId: Int) =
        API.apiService.getCharactersByEventId(eventId)

    override fun getComicsByEventId(eventId: Int) = API.apiService.getComicsByEventId(eventId)

    override fun getCreatorsByEventId(eventId: Int) = API.apiService.getCreatorsByEventId(eventId)

    override fun getSeriesByEventId(eventId: Int) = API.apiService.getSeriesByEventId(eventId)

    override fun getStoriesByEventId(eventId: Int) = API.apiService.getStoriesByEventId(eventId)
    override fun getAllSeries() = API.apiService.getAllSeries()

    override fun getSeriesById(seriesId: Int) = API.apiService.getSeriesById(seriesId)

    override fun getCharactersBySeriesId(seriesId: Int) =
        API.apiService.getCharactersBySeriesId(seriesId)

    override fun getComicsBySeriesId(seriesId: Int) = API.apiService.getComicsBySeriesId(seriesId)

    override fun getCreatorsBySeriesId(seriesId: Int) =
        API.apiService.getCreatorsBySeriesId(seriesId)

    override fun getEventsBySeriesId(seriesId: Int) = API.apiService.getEventsBySeriesId(seriesId)

    override fun getStoriesBySeriesId(seriesId: Int) = API.apiService.getStoriesBySeriesId(seriesId)
    override fun getAllStories() = API.apiService.getAllStories()

    override fun getStoryById(storyId: Int) = API.apiService.getStoryById(storyId)

    override fun getCharactersByStoryId(storyId: Int) =
        API.apiService.getCharactersByStoryId(storyId)

    override fun getComicsByStoryId(storyId: Int) = API.apiService.getComicsByStoryId(storyId)

    override fun getCreatorsByStoryId(storyId: Int) = API.apiService.getCreatorsByStoryId(storyId)

    override fun getEventsByStoryId(storyId: Int) = API.apiService.getEventsByStoryId(storyId)

    override fun getSeriesByStoryId(storyId: Int) = API.apiService.getSeriesByStoryId(storyId)
}