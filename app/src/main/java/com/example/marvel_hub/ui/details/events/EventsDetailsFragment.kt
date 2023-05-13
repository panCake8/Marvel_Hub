package com.example.marvel_hub.ui.details.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.events.adapter.ParentEventsAdapter
import com.example.marvel_hub.util.EventObserver

class EventsDetailsFragment: BaseFragment<FragmentEventsDetailsBinding,EventsDetailsViewModel>() {
    override val viewModel: EventsDetailsViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_events_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        setUpTransition()

    }
    private fun setUpAdapter(){
        binding.mainRecycler.adapter = ParentEventsAdapter(viewModel, viewLifecycleOwner)
    }

    private fun initArguments(){
        //viewModel.getEventById()
    }
    private fun setUpTransition() {
        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver{
            if (it != null){

            }
        })
    }
}