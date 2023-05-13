package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener

class HomeEventsAdapter(listener: HomeInteractionListener) :
    BaseNestedAdapter<EventModel>(listener) {
    override val layoutId: Int
        get() = R.layout.item_events

}