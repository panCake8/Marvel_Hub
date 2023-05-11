package com.example.marvel_hub.ui.home.adapter.intreactions


import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter


interface HomeEventInteractionsListener : BaseAdapter.BaseAdapterListener {
    fun onClickHomeEventItem(event: EventModel)
}