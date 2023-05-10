package com.example.marvel_hub.ui.characters.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

class CharacterAdapter(items: List<CharactersModel>, listener: CharacterInteractionListener) :
    BaseAdapter<CharactersModel>(items, listener) {

    override val getLayoutId: Int  get() = R.layout.item_character_card
}


