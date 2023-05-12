package com.example.marvel_hub.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.databinding.FragmentEventsSeeAllBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.events.event_recycler.EventsSeeAllAdapter
import com.example.marvel_hub.ui.events.viewModel.EventsViewModel

class EventsSeeAllFragment :
    BaseFragment<FragmentEventsSeeAllBinding, EventsViewModel>() {


    override val viewModel: EventsViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_events_see_all


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()

    }


    fun setUp() {
//        val adapter = EventsSeeAllAdapter(emptyList(), this)
//        binding.recyclerEvents.adapter=adapter
        viewModel.fetchAllEvents()
        val adapter = EventsSeeAllAdapter(emptyList(), viewModel)
        binding.recyclerEvents.adapter = adapter
    }


}