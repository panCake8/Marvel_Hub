package com.example.marvel_hub.ui.details.stories.adapters

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildStoriesCharactersAdapter(items: List<CharactersModel>, listener: BaseAdapterListener) :
    BaseAdapter<CharactersModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_character_card
}