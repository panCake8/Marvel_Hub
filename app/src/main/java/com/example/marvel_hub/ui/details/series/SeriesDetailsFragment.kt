package com.example.marvel_hub.ui.details.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSeriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.series.adapters.ParentSeriesAdapter
import com.example.marvel_hub.util.EventObserver

class SeriesDetailsFragment : BaseFragment<FragmentSeriesDetailsBinding, SeriesDetailsViewModel>() {
    override val viewModel: SeriesDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_series_details
    val argument: SeriesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArguments()
        setupAdapter()
    }

    private fun setupArguments() {

    }

    private fun setupAdapter() {
        binding.mainRecycler.adapter = ParentSeriesAdapter(viewModel, viewLifecycleOwner)
        val id = argument.id
        viewModel.getSeriesById(id)
        viewModel.getCharactersBySeriesId(id)
        viewModel.getComicsBySeriesId(id)
        viewModel.getStoriesBySeriesId(id)
        viewModel.getEventsBySeriesId(id)

    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToCharacterDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToEventsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToComicsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.storiesEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToStoriesDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
    }

}