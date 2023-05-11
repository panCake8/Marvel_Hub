package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener

class HomeSeriesAdapter(listener: HomeInteractionListener) :
    BaseNestedAdapter<SeriesModel>(listener) {
    override val layoutId: Int
        get() = R.layout.item_comics

}