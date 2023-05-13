package com.example.marvel_hub.ui.details.stories

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel

sealed interface StoriesDetailsEvents {
    object ReadyState:StoriesDetailsEvents

    data class ClickEventStory(val event: EventModel) : StoriesDetailsEvents

    data class ClickComicStory(val comic: ComicModel) : StoriesDetailsEvents

    data class ClickSeriesStory(val series: SeriesModel) : StoriesDetailsEvents

    data class ClickCharacterStory(val character: CharactersModel) : StoriesDetailsEvents

}