package com.example.marvel_hub.ui.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.StoryListener

class StoriesAdapter(items: List<StoriesModel>, listener: StoryListener) :
    BaseAdapter<StoriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_stories
}