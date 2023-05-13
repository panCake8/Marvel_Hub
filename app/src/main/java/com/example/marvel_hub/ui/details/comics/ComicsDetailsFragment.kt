package com.example.marvel_hub.ui.details.comics


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.comics.adapters.ParentComicAdapter


class ComicsDetailsFragment : BaseFragment<FragmentComicsDetailsBinding, ComicsDetailsViewModel>() {
    override val viewModel: ComicsDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_comics_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        observeEvents()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentComicAdapter(viewModel, viewLifecycleOwner)
    }

    private fun initArguments() {
        viewModel.getComicById(0)
    }
    private fun observeEvents() {
        viewModel.comicDetails.observe(viewLifecycleOwner) { clickEvent ->
            when (clickEvent) {
//                is CharacterDetailsEvents.ClickEventEvent -> navigateToEventsDetails(clickEvent.event)
//                is CharacterDetailsEvents.ClickComicEvent -> navigateToComicDetails(clickEvent.comic)
//                is CharacterDetailsEvents.ClickSeriesEvent -> navigateToSeriesDetails(clickEvent.series)
                else -> {}
            }
            viewModel.clearEvents()
        }
    }
}