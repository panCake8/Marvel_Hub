package com.example.marvel_hub.ui.details.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentStoriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.stories.adapters.ParentStoriesDetailsAdapter
import com.example.marvel_hub.util.EventObserver

class StoriesDetailsFragment :
    BaseFragment<FragmentStoriesDetailsBinding, StoriesDetailsViewModel>() {

    override val viewModel: StoriesDetailsViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_stories_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
        observeEvents()
    }


    private fun setUp() {

        binding.mainRecycler.adapter = ParentStoriesDetailsAdapter(viewModel, this)

        viewModel.getSeriesByStoryId(storyID)
        viewModel.getCharactersByStoryId(storyID)
        viewModel.getSeriesByStoryId(storyID)
        viewModel.getComicsByStoryId(storyID)
        viewModel.getEventsByStoryId(storyID)

    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {

            }
        })
    }

    companion object {
        val storyID = 24
    }


}