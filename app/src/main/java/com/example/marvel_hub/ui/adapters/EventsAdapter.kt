package com.example.marvel_hub.ui.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.EventsListener

class EventsAdapter(items: List<EventModel>, listener: EventsListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_events
}