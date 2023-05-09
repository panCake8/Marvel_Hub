package com.example.marvel_hub.ui.details.character.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildSeriesEventsAdapter(items: List<EventModel>, listener: BaseAdapterListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId = R.layout.item_comics
}