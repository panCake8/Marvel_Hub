package com.example.marvel_hub.ui.details.stories.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildStoriesSeriesAdapter(items: List<SeriesModel>, listener: BaseAdapterListener?) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_details_stories
}