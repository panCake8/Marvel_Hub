package com.example.marvel_hub.ui.details.events.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildEventsComicsAdapter(items: List<ComicModel>, listener: BaseAdapterListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_comics
}