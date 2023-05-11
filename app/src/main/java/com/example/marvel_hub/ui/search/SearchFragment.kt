package com.example.marvel_hub.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.adapter.SeriesAdapter
import com.example.marvel_hub.ui.search.adapter.EventAdapter
import com.example.marvel_hub.ui.search.viewModel.Data
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel
import com.google.android.material.chip.Chip


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels({ requireActivity() })


    override val layoutId: Int
        get() = R.layout.fragment_search


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        getData()

    }

    private fun getData() {
        binding.searchBar.doOnTextChanged { text, start, before, count ->

            if (showSelectedChips() == "Comics") viewModel.getComicData(text.toString())
            else if (showSelectedChips() == "Series") viewModel.getSeriesData(text.toString())
            else if (showSelectedChips() == "Events") viewModel.getEventData(text.toString())

        }


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
                    else -> seriesAdapter

                }
        }
    }

    private fun showSelectedChips(): String {
        val selectedChipsIds = binding.filterChipComponent.checkedChipIds
        val selectedChips = mutableListOf<String>()
        for (id in selectedChipsIds) {
            val chip = binding.filterChipComponent.findViewById<Chip>(id)
            selectedChips.add(chip.text.toString())
        }

        return selectedChips.joinToString(", ")
    }

}

