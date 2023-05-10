package com.example.marvel_hub.ui.series

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSeriesBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.series.adapter.SeriesAdapter
import com.example.marvel_hub.ui.series.viewModel.SeriesViewModel
import com.example.marvel_hub.util.EventObserver

class SeriesFragment : BaseFragment<FragmentSeriesBinding, SeriesViewModel>() {

    override val viewModel: SeriesViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_series

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SeriesAdapter(mutableListOf(),viewModel)
        binding.recyclerSeries.adapter = adapter


        viewModel.selectedSeriesItem.observe(viewLifecycleOwner,EventObserver{
            //Todo
        })
    }
}