package com.example.marvel_hub.ui.home.util

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel

sealed class HomeItem(val rank: Int) {
    data class Banner(val data: List<String>) : HomeItem(0)
    data class Comics(val data: List<ComicModel>) : HomeItem(1)
    data class Events(val data: List<EventModel>) : HomeItem(2)
    data class Series(val data: List<SeriesModel>) : HomeItem(3)

    object QuizGameBanner : HomeItem(4)
}
