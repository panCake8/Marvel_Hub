package com.example.marvel_hub.ui.search.listener

import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface CharacterSearchListener : BaseAdapter.BaseAdapterListener {
    fun onCharacterClick(character : CharacterEntity)
}