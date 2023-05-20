package com.example.marvel_hub.ui.search.listener

import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface ComicSearchListener : BaseAdapter.BaseAdapterListener {
    fun onComicClick(comic : ComicEntity)
}