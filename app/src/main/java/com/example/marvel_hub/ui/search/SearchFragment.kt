package com.example.marvel_hub.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.adapter.CreatorAdapter
import com.example.marvel_hub.ui.search.adapter.EventAdapter
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    private val eventAdapter = EventAdapter(mutableListOf(), viewModel)

    private val comicAdapter = ComicsAdapter(mutableListOf(), viewModel)

    private val creatorAdapter = CreatorAdapter(mutableListOf(), viewModel)

    override val layoutId: Int
        get() = R.layout.fragment_search


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        viewModel.dataType.observe(viewLifecycleOwner) {
            binding.recyclerSearchResult.adapter =
                when (viewModel.dataType.value) {
                    1 -> comicAdapter
                    2 -> eventAdapter
                    3 -> creatorAdapter
                    else -> null
                }
        }
    }

}

