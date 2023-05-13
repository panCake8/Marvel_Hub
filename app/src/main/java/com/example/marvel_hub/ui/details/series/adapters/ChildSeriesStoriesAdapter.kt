package com.example.marvel_hub.ui.details.series.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.details.listeners.StoryListener

class ChildSeriesStoriesAdapter(items: List<StoriesModel>, listener: StoryListener) :
    BaseAdapter<StoriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_stories
}