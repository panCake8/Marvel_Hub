package com.example.marvel_hub.ui.details.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSeriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.series.adapter.ParentSeriesAdapter
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesDetailsFragment : BaseFragment<FragmentSeriesDetailsBinding, SeriesDetailsViewModel>() {

    override val viewModel: SeriesDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_series_details
    private  val argument: SeriesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        getAllData()
        observeEvents()
    }


    private fun setupAdapter() {
        binding.mainRecycler.adapter = ParentSeriesAdapter(viewModel, viewLifecycleOwner)
    }

    private fun getAllData() {
        viewModel.getAllDataById(argument.id)
    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToCharacterDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToEventsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToComicsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.storiesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SeriesDetailsFragmentDirections.actionSeriesDetailsFragmentToStoriesDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })
    }

}