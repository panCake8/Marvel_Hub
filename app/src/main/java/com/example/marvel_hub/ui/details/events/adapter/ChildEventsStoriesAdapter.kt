package com.example.marvel_hub.ui.details.events.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildEventsStoriesAdapter(items: List<StoriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<StoriesModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_series_card
}