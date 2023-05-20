package com.example.marvel_hub.ui.search


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()
    override val layoutId = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        observeEvents()
    }

    @SuppressLint("CheckResult")
    private fun initListeners() {
        Observable.create { emitter ->
            binding.searchBar.doOnTextChanged { text, _, _, _ ->
                text?.let { emitter.onNext(it) }
            }
        }.debounce(1, TimeUnit.SECONDS).subscribe {
            viewModel.getDataBySearchText()
        }

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

