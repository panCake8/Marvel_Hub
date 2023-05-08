package com.example.marvel_hub.ui.character.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

class CharacterAdapter(items: List<CharactersModel>, listener: CharacterInteractionListener) :
    BaseAdapter<CharactersModel>(items, listener) {
    override val getLayoutId: Int = R.layout.item_character_card
}

interface CharacterInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickCharacter(character: CharactersModel)
}