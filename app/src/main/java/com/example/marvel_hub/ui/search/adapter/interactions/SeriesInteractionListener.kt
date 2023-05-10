package com.example.marvel_hub.ui.search.adapter.interactions

import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface SeriesInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickSeries(creator: SeriesModel)
}