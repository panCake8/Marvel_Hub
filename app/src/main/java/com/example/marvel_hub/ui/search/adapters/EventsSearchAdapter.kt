package com.example.marvel_hub.ui.search.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.EventsListener
import com.example.marvel_hub.ui.search.listener.EventsSearchListener

class EventsSearchAdapter(items: List<EventModel>, listener: EventsSearchListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId = R.layout.item_search_event
}