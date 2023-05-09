package com.example.marvel_hub.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.adapter.CreatorAdapter
import com.example.marvel_hub.ui.search.adapter.EventAdapter
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    private val eventAdapter = EventAdapter(mutableListOf(), viewModel)

   private val comicAdapter = ComicsAdapter(mutableListOf(), viewModel)

    private val creatorAdapter = CreatorAdapter(mutableListOf(), viewModel)

    override val layoutId: Int
        get() = R.layout.fragment_search


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onSelectComicChip()
        onSelectCreatorChip()
        onSelectEventChip()

        viewModel.result.observe(viewLifecycleOwner) {
            onSelectEventChip()
            onSelectCreatorChip()
        }
    }


    private fun onSelectComicChip() {
        binding.chipComics.setOnClickListener {
            binding.recyclerSearchResult.adapter = comicAdapter
        }


    }

    private fun onSelectEventChip() {
        binding.chipEvents.setOnClickListener {
            binding.recyclerSearchResult.adapter = eventAdapter
        }

    }

    private fun onSelectCreatorChip() {
        binding.chipCreators.setOnClickListener {
            binding.recyclerSearchResult.adapter = creatorAdapter
        }

    }
    val debounceOperator = Observable.create {emitter ->
        binding.searchBar.doOnTextChanged { text, start, before, count ->
            emitter.onNext(text.toString())
        }
    }.debounce (1,TimeUnit.SECONDS)



}

