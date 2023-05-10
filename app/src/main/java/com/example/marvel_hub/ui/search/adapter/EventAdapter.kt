package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

class EventAdapter(items: List<EventModel>, listener: EventInteractionListener) :
    BaseAdapter<EventModel>(items, listener) {

    override val getLayoutId: Int
        get() =  R.layout.item_search_envents

}

interface EventInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickEvent(event: EventModel)
}