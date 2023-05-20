package com.example.marvel_hub.ui.search.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.listeners.CharacterListener
import com.example.marvel_hub.ui.search.listener.CharacterSearchListener

class CharacterSearchAdapter(items: List<CharactersModel>, listener: CharacterSearchListener) :
    BaseAdapter<CharactersModel>(items, listener) {
    override val getLayoutId = R.layout.item_search_characters
}