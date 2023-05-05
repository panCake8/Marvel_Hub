package com.example.marvel_hub.data.repository

import com.example.marvel_hub.data.api.API

class MarvelRepository : IMarvelRepository {
    override fun getAllCharacters() = API.apiService.getAllCharacters()

    override fun getCharacterById(characterId: Int) =
        API.apiService.getCharacterById(characterId = characterId)

    override fun getComicsByCharacterId(characterId: Int) =  API.apiService.getComicsByCharacterId(characterId)

    override fun getEventsByCharacterId(characterId: Int) = API.apiService.getEventsByCharacterId(characterId)

    override fun getSeriesByCharacterId(characterId: Int) =API.apiService.getSeriesByCharacterId(characterId)

    override fun getStoriesByCharacterId(characterId: Int) =API.apiService.getStoriesByCharacterId(characterId)

    override fun getAllComics() = API.apiService.getAllComics()

    override fun getComicById(comicId: Int) = API.apiService.getComicsById(comicId)

    override fun getCharactersByComicId(comicId: Int) = API.apiService.getCharactersByComicId(comicId)

    override fun getCreatorsByComicId(comicId: Int)= API.apiService.getCreatorsByComicId(comicId)

    override fun getEventByComicId(comicId: Int) = API.apiService.getEventByComicId(comicId)

    override fun getStoriesByComicId(comicId: Int) = API.apiService.getStoriesByComicId(comicId)

    override fun getAllCreators() = API.apiService.getAllCreators()

    override fun getCreatorById(creatorId: Int) = API.apiService.getCreatorById(creatorId)

    override fun getComicsByCreatorId(creatorId: Int) =API.apiService.getComicsByCharacterId(creatorId)

    override fun getEventsByCreatorId(creatorId: Int) = API.apiService.getEventsByCreatorId(creatorId)

    override fun getSeriesByCreatorId(creatorId: Int) = API.apiService.getSeriesByCreatorId(creatorId)

    override fun getStoriesByCreatorId(creatorId: Int) = API.apiService.getStoriesByCreatorId(creatorId)

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