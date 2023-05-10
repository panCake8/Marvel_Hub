package com.example.marvel_hub.ui.details.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment

class EventsDetailsFragment: BaseFragment<FragmentEventsDetailsBinding,EventsDetailsViewModel>() {
    override val viewModel: EventsDetailsViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_events_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}