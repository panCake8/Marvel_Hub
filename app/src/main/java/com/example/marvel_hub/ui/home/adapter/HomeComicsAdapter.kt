package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener


class HomeComicsAdapter(listener: HomeInteractionListener) :
    BaseNestedAdapter<ComicModel>(listener) {
    override val layoutId: Int
        get() = R.layout.item_comics

}