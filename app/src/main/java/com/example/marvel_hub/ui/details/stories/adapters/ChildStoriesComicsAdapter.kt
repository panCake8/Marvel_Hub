package com.example.marvel_hub.ui.details.stories.adapters

import android.view.accessibility.AccessibilityManager.AudioDescriptionRequestedChangeListener
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.ui.base.BaseAdapter

class ChildStoriesComicsAdapter(items: List<ComicModel>, listener: BaseAdapterListener) :
    BaseAdapter<ComicModel>(items, listener) {
    override val getLayoutId: Int
        get() = R.layout.item_details_comics
}