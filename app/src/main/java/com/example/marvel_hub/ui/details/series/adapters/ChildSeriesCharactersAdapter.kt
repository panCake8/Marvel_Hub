package com.example.marvel_hub.ui.details.series.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildSeriesCharactersAdapter(items: List<SeriesModel>, listener: BaseAdapterListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_character
}