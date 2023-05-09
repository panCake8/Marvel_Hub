package com.example.marvel_hub.ui.aboutmarvel

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.ui.base.BaseAdapter

class AboutMarvelAdapter(items: List<CreatorModel>, listener: BaseAdapterListener) :
    BaseAdapter<CreatorModel>(items, listener) {

    override val getLayoutId: Int
        get() = R.layout.item_about_marvel

}

interface OnClickMarvel : BaseAdapter.BaseAdapterListener {
    fun onClickMarvel(comics: CreatorModel)
}