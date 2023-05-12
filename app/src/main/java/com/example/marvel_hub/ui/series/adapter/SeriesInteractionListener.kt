package com.example.marvel_hub.ui.series.adapter

import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface SeriesInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickSeriesItem(series: SeriesModel)
}