package com.example.marvel_hub.ui.details.events.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class EventsSeriesChildAdapter(items: List<SeriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_comics
}