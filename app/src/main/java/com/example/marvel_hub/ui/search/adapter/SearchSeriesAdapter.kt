package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.adapter.interactions.SeriesInteractionListener

class SearchSeriesAdapter(items: List<SeriesModel>, listener: SeriesInteractionListener) :
    BaseAdapter<SeriesModel>(items, listener) {

    override val getLayoutId = R.layout.item_search_series

}

