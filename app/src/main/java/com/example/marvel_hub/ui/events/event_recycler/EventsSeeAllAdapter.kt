package com.example.marvel_hub.ui.events.event_recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.databinding.FragmentEventsSeeAllItemBinding

class EventsSeeAllAdapter(items:List<EventModel>, listener: BaseAdapterListener?,) :
    com.example.marvel_hub.ui.base.BaseAdapter<EventModel>(items, listener,) {

    override val getLayoutId: Int
        get() = R.layout.fragment_events_see_all_item


}




