package com.example.marvel_hub.ui.details.comics.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildComicsStoriesAdapter(items: List<StoriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<StoriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_series_card
}