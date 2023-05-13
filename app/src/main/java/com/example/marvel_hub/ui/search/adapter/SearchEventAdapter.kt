package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.adapter.interactions.EventInteractionListener

class SearchEventAdapter(items: List<EventModel>, listener: EventInteractionListener) :
    BaseAdapter<EventModel>(items, listener) {

    override val getLayoutId = R.layout.item_search_envents

}

