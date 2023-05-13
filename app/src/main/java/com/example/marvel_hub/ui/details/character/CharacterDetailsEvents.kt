package com.example.marvel_hub.ui.details.character

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel

sealed interface CharacterDetailsEvents {
    object ReadyState:CharacterDetailsEvents

    data class ClickEventEvent(val event: EventModel) : CharacterDetailsEvents

    data class ClickComicEvent(val comic: ComicModel) : CharacterDetailsEvents

    data class ClickSeriesEvent(val series: SeriesModel) : CharacterDetailsEvents

    data class ClickStoriesEvent(val stories: StoriesModel) : CharacterDetailsEvents

}