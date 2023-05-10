package com.example.marvel_hub.ui.stories.adapter

import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface StoriesInteractionListener: BaseAdapter.BaseAdapterListener{

    fun onClickStoryItem(story: StoriesModel)
}