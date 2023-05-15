package com.example.marvel_hub.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsSeeAllBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.events.adapter.EventsSeeAllAdapter
import com.example.marvel_hub.util.EventObserver

class EventsSeeAllFragment :
    BaseFragment<FragmentEventsSeeAllBinding, EventsViewModel>() {
    override val viewModel: EventsViewModel by viewModels()
    override val layoutId = R.layout.fragment_events_see_all


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        observeEvent()
    }

    private fun setUpAdapter() {
        binding.recyclerEvents.adapter = EventsSeeAllAdapter(emptyList(), viewModel)
    }

    private fun observeEvent() {
        viewModel.selectedEventItem.observe(viewLifecycleOwner, EventObserver {
            val nav =
                EventsSeeAllFragmentDirections.actionEventsSeeAllFragmentToEventsDetailsFragment(it!!)
            findNavController().navigate(nav)

        })
    }

}