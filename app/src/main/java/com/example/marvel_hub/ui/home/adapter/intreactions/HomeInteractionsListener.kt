package com.example.marvel_hub.ui.home.adapter.intreactions

import com.example.marvel_hub.ui.base.BaseAdapter

interface HomeInteractionsListener : BaseAdapter.BaseAdapterListener {
    fun onClickSeriesViewAll()
    fun onClickComicsViewAll()
    fun onClickEventsViewAll()
}