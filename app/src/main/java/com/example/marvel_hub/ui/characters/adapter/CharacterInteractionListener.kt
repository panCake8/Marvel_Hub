package com.example.marvel_hub.ui.characters.adapter

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface CharacterInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickCharacterItem(character: CharactersModel)
}