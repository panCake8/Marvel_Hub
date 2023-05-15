package com.example.marvel_hub.ui.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.ComicListener

class ComicsAdapter(items: List<ComicModel>, listener: ComicListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_comics
}