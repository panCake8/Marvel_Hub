package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel


sealed class SearchItems(rank: Int) {
    data class Comics(val data: List<ComicModel>) : SearchItems(0)
    data class Events(val data: List<EventModel>) : SearchItems(1)
    data class Series(val data: List<SeriesModel>) : SearchItems(2)
}

