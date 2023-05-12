package com.example.marvel_hub.ui.search.adapter.interactions

import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface EventInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickEvent(event: EventModel)
}