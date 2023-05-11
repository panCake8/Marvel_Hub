package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeSeriesInteractionsListener

class HomeSeriesAdapter(items: List<SeriesModel>, listener: HomeSeriesInteractionsListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_comics
}