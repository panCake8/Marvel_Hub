package com.example.marvel_hub.ui.events.event_recycler

import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface EventsSeeAllListener:BaseAdapter.BaseAdapterListener {
    fun onClick(event:EventModel)
}