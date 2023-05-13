package com.example.marvel_hub.ui.events.event_recycler

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.ui.base.BaseAdapter

class EventsSeeAllAdapter(items:List<EventModel>, listener: BaseAdapterListener,) :
    BaseAdapter<EventModel>(items, listener,) {

    override val getLayoutId= R.layout.fragment_events_see_all_item

}




