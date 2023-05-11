package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeComicInteractionsListener


class HomeComicsAdapter(items: List<ComicModel>, listener: HomeComicInteractionsListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_comics
}