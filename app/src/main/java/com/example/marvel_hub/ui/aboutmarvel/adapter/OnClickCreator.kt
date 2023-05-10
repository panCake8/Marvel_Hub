package com.example.marvel_hub.ui.aboutmarvel.adapter

import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.ui.base.BaseAdapter

interface OnClickCreator : BaseAdapter.BaseAdapterListener {
    fun onClickCreatorItem(creator: CreatorModel)
}