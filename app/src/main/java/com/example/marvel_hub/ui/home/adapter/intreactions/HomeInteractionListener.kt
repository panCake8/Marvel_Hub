package com.example.marvel_hub.ui.home.adapter.intreactions


import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.home.adapter.BaseInteractListener

interface HomeInteractionListener : BaseInteractListener {
    fun onEventItemClick(eventItem: EventModel)
    fun onComicItemClick(comicItem: ComicModel)
    fun onCharacterItemClick(characterItem: CharactersModel)
    fun onSeriesItemClick(seriesItem: SeriesModel)

    fun onEventViewAllClick()
    fun onComicViewAllClick()
    fun onCharacterViewAllClick()
    fun onSeriesViewAllClick()
}