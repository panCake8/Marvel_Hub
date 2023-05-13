package com.example.marvel_hub.ui.stories.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.stories.adapter.StoriesInteractionListener

class StoriesAdapter(stories: List<StoriesModel>,listener: StoriesInteractionListener)
    :BaseAdapter<StoriesModel>(stories,listener) {
    override val getLayoutId: Int
        get() = R.layout.item_story_card
}


