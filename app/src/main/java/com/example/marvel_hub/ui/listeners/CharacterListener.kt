package com.example.marvel_hub.ui.listeners

import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface CharacterListener : BaseAdapter.BaseAdapterListener {
    fun onCharacterClick(character : CharactersModel)
}