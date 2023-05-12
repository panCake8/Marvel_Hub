package com.example.marvel_hub.ui.details.series.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.details.listeners.CharacterListener

class ChildSeriesCharactersAdapter(items: List<SeriesModel>, listener: CharacterListener) :
    BaseAdapter<SeriesModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_character
}