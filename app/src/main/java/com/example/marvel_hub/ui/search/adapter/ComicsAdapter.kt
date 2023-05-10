package com.example.marvel_hub.ui.search

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.adapter.interactions.ComicInteractionListener

class ComicsAdapter(items: List<ComicModel>, listener: ComicInteractionListener) :
    BaseAdapter<ComicModel>(items, listener) {

    override val getLayoutId: Int
    get() =  R.layout.item_search_comics

}

