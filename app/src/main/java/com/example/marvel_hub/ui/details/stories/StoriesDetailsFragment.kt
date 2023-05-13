package com.example.marvel_hub.ui.details.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentStoriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.stories.adapters.ParentStoriesDetailsAdapter
import com.example.marvel_hub.util.EventObserver

class StoriesDetailsFragment :
    BaseFragment<FragmentStoriesDetailsBinding, StoriesDetailsViewModel>() {

    override val viewModel: StoriesDetailsViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_stories_details
    val argument: StoriesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        observeEvents()
    }


    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentStoriesDetailsAdapter(viewModel, this)
    }

    private fun initArguments() {
        val id = argument.id
        viewModel.getSeriesByStoryId(id)
        viewModel.getCharactersByStoryId(id)
        viewModel.getSeriesByStoryId(id)
        viewModel.getComicsByStoryId(id)
        viewModel.getEventsByStoryId(id)
    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToCharacterDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToEventsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToComicsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToSeriesDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
    }

}