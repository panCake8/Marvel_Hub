package com.example.marvel_hub.ui.details.listeners

import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface EventsListener : BaseAdapter.BaseAdapterListener {
    fun onEventClick(event : EventModel)
}