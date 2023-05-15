package com.example.marvel_hub.ui.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.CharacterListener

class CharacterAdapter(items: List<ComicModel>, listener: CharacterListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId = R.layout.item_details_characters
}