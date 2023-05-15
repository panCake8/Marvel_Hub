package com.example.marvel_hub.ui.search


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()
    override val layoutId = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SearchFragmentDirections.actionSearchFragmentToCharacterDetailsFragment(it.id!!)
            findNavController().navigate(nav)
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            val nav = SearchFragmentDirections.actionSearchFragmentToEventsDetailsFragment(it.id!!)
            findNavController().navigate(nav)
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav = SearchFragmentDirections.actionSearchFragmentToSeriesDetailsFragment(it.id!!)
            findNavController().navigate(nav)
        })

        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            val nav = SearchFragmentDirections.actionSearchFragmentToComicsDetailsFragment(it.id!!)
            findNavController().navigate(nav)
        })
    }
}

