package com.example.marvel_hub.ui.details.events.adapter

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildEventsCharacterAdapter(items: List<CharactersModel>, listener: BaseAdapterListener) :
    BaseAdapter<CharactersModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_details_character
}