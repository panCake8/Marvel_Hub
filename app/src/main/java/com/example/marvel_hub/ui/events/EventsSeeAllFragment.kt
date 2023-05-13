package com.example.marvel_hub.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsSeeAllBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.events.event_recycler.EventsSeeAllAdapter
import com.example.marvel_hub.ui.events.viewModel.EventsViewModel
import com.example.marvel_hub.util.EventObserver

class EventsSeeAllFragment :
    BaseFragment<FragmentEventsSeeAllBinding, EventsViewModel>() {
    override val viewModel: EventsViewModel by viewModels()
    override val layoutId = R.layout.fragment_events_see_all


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        viewModel.selectedEventItem.observe(viewLifecycleOwner, EventObserver {
            //TODO()
        })
    }


    private fun setUpAdapter() {
        binding.recyclerEvents.adapter = EventsSeeAllAdapter(emptyList(), viewModel)
    }


}