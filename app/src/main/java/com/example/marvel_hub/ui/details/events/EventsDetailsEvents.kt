package com.example.marvel_hub.ui.details.events

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.details.character.CharacterDetailsEvents

sealed interface EventsDetailsEvents {
    object ReadyState:EventsDetailsEvents

    data class ClickCharacterEvent(val character: CharactersModel) : EventsDetailsEvents

    data class ClickComicEvent(val comic: ComicModel) : EventsDetailsEvents

    data class ClickSeriesEvent(val series: SeriesModel) : EventsDetailsEvents

    data class ClickStoriesEvent(val stories: StoriesModel) : EventsDetailsEvents

}