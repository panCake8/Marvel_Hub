package com.example.marvel_hub.ui.listeners

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface ComicListener : BaseAdapter.BaseAdapterListener {
    fun onComicClick(comic : ComicModel)
}