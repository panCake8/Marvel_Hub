package com.example.marvel_hub.ui.search.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.ComicListener
import com.example.marvel_hub.ui.search.listener.ComicSearchListener

class ComicsSearchAdapter(items: List<ComicModel>, listener: ComicSearchListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId = R.layout.item_search_comics
}