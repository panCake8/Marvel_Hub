package com.example.marvel_hub.ui.home.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener

class HomeCharacterAdapter(listener: HomeInteractionListener) :
    BaseNestedAdapter<CharactersModel>(listener) {
    override val layoutId: Int
        get() = R.layout.item_character

}