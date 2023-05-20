package com.example.marvel_hub.ui.search.listener

import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.ui.base.BaseAdapter

interface SeriesSearchListener : BaseAdapter.BaseAdapterListener {
    fun onSeriesClick(series: SeriesEntity)
}