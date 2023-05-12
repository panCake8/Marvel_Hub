package com.example.marvel_hub.ui.details.comics.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.details.listeners.SeriesListener

class ChildComicsSeriesAdapter(items: List<SeriesModel>, listener: SeriesListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_comics
}