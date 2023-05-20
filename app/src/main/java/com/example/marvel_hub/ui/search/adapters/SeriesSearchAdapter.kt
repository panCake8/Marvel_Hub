package com.example.marvel_hub.ui.search.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.listener.SeriesSearchListener

class SeriesSearchAdapter(items: List<SeriesModel>, listener: SeriesSearchListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_series
}