package com.example.marvel_hub.ui.comics.adapter

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface OnClickItemComic: BaseAdapter.BaseAdapterListener {
    fun onClickItemComic(comic: ComicModel)
}