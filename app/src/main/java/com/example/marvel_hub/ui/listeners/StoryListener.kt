package com.example.marvel_hub.ui.listeners

import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface StoryListener : BaseAdapter.BaseAdapterListener {
    fun onStoryClick(story: StoriesModel)
}