package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.adapter.interactions.CharacterInteractionListener

class SearchCharactersAdapter(items: List<CharactersModel>, listener: CharacterInteractionListener) :
    BaseAdapter<CharactersModel>(items, listener) {

    override val getLayoutId: Int
    get() =  R.layout.item_search_characters

}

