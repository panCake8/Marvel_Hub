package com.example.marvel_hub.ui.details.comics

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel

sealed interface ComicsDetailsEvents{
    object ReadyState: ComicsDetailsEvents

    data class ClickCharacterEvent(val character: CharactersModel) : ComicsDetailsEvents

    data class ClickEventEvent(val event: EventModel) : ComicsDetailsEvents

    data class ClickSeriesEvent(val series: SeriesModel) : ComicsDetailsEvents

    data class ClickStoriesEvent(val Story: StoriesModel) : ComicsDetailsEvents

}