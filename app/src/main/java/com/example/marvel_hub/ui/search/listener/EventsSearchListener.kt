package com.example.marvel_hub.ui.search.listener

import android.provider.CalendarContract.EventsEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface EventsSearchListener : BaseAdapter.BaseAdapterListener {
    fun onEventClick(event : EventEntity)
}