package com.example.marvel_hub.ui.home.adapter.intreactions


import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter


interface HomeSeriesInteractionsListener : BaseAdapter.BaseAdapterListener {
    fun onClickHomeSeriesItem(series: SeriesModel)
}