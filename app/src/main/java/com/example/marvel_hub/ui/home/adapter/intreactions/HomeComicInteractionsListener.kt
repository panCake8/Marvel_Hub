package com.example.marvel_hub.ui.home.adapter.intreactions

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter


interface HomeComicInteractionsListener : BaseAdapter.BaseAdapterListener {
    fun onClickHomeComicItem(comic: ComicModel)
}