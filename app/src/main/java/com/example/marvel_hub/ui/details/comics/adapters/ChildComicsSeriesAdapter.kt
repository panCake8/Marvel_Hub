package com.example.marvel_hub.ui.details.comics.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildComicsSeriesAdapter(items: List<SeriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_comics
}