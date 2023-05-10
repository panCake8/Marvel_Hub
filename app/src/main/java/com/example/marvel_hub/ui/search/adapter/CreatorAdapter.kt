package com.example.marvel_hub.ui.search.adapter

import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CreatorModel

class CreatorAdapter(items: List<CreatorModel>, listener: CreatorInteractionListener) :
    BaseAdapter<CreatorModel>(items, listener) {

    override val getLayoutId: Int
        get() =  R.layout.item_search_creators

}

interface CreatorInteractionListener : BaseAdapter.BaseAdapterListener {
    fun onClickCreator(creator: CreatorModel)
}