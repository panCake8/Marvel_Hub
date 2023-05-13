package com.example.marvel_hub.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsSeeAllBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.characters.CharacterFragmentDirections
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
        backClick()
        viewModel.selectedEventItem.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    EventsSeeAllFragmentDirections.actionEventsSeeAllFragmentToEventsDetailsFragment(
                        it
                    )
                findNavController().navigate(nav)
            }
        })
    }

    private fun backClick(){
        binding.toolbarEvents.setNavigationOnClickListener{
            findNavController().popBackStack()
        }
    }
    private fun setUpAdapter() {
        binding.recyclerEvents.adapter = EventsSeeAllAdapter(emptyList(), viewModel)
    }


}