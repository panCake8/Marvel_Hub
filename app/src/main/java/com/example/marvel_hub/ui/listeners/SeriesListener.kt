package com.example.marvel_hub.ui.listeners

import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface SeriesListener : BaseAdapter.BaseAdapterListener {
    fun onSeriesClick(series: SeriesModel)
}