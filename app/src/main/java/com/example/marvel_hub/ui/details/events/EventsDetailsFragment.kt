package com.example.marvel_hub.ui.details.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentEventsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.comics.ComicsDetailsFragmentArgs
import com.example.marvel_hub.ui.details.events.adapter.ParentEventsAdapter
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EventsDetailsFragment : BaseFragment<FragmentEventsDetailsBinding, EventsDetailsViewModel>() {

    override val viewModel: EventsDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_events_details
    private val arguments: ComicsDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getAllData()
        observeEvents()

    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentEventsAdapter(viewModel, viewLifecycleOwner)
    }

    private fun getAllData() {
        viewModel.getAllDataById(arguments.id)
    }

    private fun observeEvents() {

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    EventsDetailsFragmentDirections.actionEventsDetailsFragmentToSeriesDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.storiesEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    EventsDetailsFragmentDirections.actionEventsDetailsFragmentToStoriesDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    EventsDetailsFragmentDirections.actionEventsDetailsFragmentToComicsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    EventsDetailsFragmentDirections.actionEventsDetailsFragmentToCharacterDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
    }
}