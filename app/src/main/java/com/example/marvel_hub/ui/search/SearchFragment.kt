package com.example.marvel_hub.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.adapter.SeriesAdapter
import com.example.marvel_hub.ui.search.adapter.EventAdapter
import com.example.marvel_hub.ui.search.viewModel.Data
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    private val eventAdapter = EventAdapter(mutableListOf(), viewModel)

    private val comicAdapter = ComicsAdapter(mutableListOf(), viewModel)

    private val seriesAdapter = SeriesAdapter(mutableListOf(), viewModel)

    override val layoutId: Int
        get() = R.layout.fragment_search


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        val eventAdapter = EventAdapter(mutableListOf(), viewModel)

         val comicAdapter = ComicsAdapter(mutableListOf(), viewModel)

         val seriesAdapter = SeriesAdapter(mutableListOf(), viewModel)
        viewModel.dataType.observe(viewLifecycleOwner) {
            binding.recyclerSearchResult.adapter =
                when (viewModel.dataType.value) {
                    Data.COMIC -> comicAdapter
                    Data.EVENT -> eventAdapter
                    Data.SERIES -> seriesAdapter
                    else -> null
                }
        }
    }

}

