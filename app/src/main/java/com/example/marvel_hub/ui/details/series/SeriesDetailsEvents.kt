package com.example.marvel_hub.ui.details.series

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.details.character.CharacterDetailsEvents

sealed interface SeriesDetailsEvents {
    object ReadyState:SeriesDetailsEvents

    data class ClickCharacterSeries(val character: CharactersModel) : SeriesDetailsEvents

    data class ClickComicSeries(val comic: ComicModel) : SeriesDetailsEvents

    data class ClickEventSeries(val event: EventModel) : SeriesDetailsEvents

    data class ClickStoriesSeries(val stories: StoriesModel) : SeriesDetailsEvents

}