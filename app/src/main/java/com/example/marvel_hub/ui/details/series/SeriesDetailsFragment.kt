package com.example.marvel_hub.ui.details.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSeriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.series.adapters.ParentSeriesAdapter

class SeriesDetailsFragment : BaseFragment<FragmentSeriesDetailsBinding, SeriesDetailsViewModel>() {
    override val viewModel: SeriesDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_series_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupArguments()
        setupAdapter()
    }

    private fun setupArguments() {

    }

    private fun setupAdapter() {
        binding.mainRecycler.adapter = ParentSeriesAdapter(viewModel, viewLifecycleOwner)
        viewModel.getSeriesById(26024)
        viewModel.getCharactersBySeriesId(26024)
        viewModel.getComicsBySeriesId(26024)
        viewModel.getStoriesBySeriesId(26024)
        viewModel.getEventsBySeriesId(26024)

    }

}