package com.example.marvel_hub.ui.details.character.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildCharacterStoriesAdapter(items: List<StoriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<StoriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_series_card
}