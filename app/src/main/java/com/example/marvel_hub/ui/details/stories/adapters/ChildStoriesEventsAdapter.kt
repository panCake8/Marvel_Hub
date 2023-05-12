package com.example.marvel_hub.ui.details.stories.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildStoriesEventsAdapter(items: List<EventModel>, listener: BaseAdapterListener) :
    BaseAdapter<EventModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_details_events
}