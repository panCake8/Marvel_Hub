package com.example.marvel_hub.ui.details.character.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.details.listeners.SeriesListener

class ChildCharacterSeriesAdapter(items: List<SeriesModel>, listener: SeriesListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_series
}