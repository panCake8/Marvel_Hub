package com.example.marvel_hub.ui.details.character.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.details.listeners.EventListener

class ChildCharacterEventsAdapter(items: List<EventModel>, listener: EventListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_events
}