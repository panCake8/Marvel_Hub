package com.example.marvel_hub.ui.stories

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class StoriesAdapter(stories: List<StoriesModel>,listener: StoriesInteractionListener):BaseAdapter<StoriesModel>(stories,listener) {
    override val getLayoutId: Int
        get() = R.layout.item_story_card
}


interface StoriesInteractionListener: BaseAdapter.BaseAdapterListener{
    fun onClickStory(story: StoriesModel)
}