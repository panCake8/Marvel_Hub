package com.example.marvel_hub.ui.details.character.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildCharacterComicsAdapter(items: List<ComicModel>, listener: BaseAdapterListener?) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_comics
}