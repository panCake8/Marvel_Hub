package com.example.marvel_hub.ui.search.adapter.interactions

import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface ComicInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickComic(comic: ComicModel)
}
