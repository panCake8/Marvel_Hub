package com.example.marvel_hub.ui.search.adapter.interactions

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface CharacterInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickCharacter(character: CharactersModel)
}