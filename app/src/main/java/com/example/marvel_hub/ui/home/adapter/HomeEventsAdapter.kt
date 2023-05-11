package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeEventInteractionsListener

class HomeEventsAdapter(items: List<EventModel>, listener: HomeEventInteractionsListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_events
}