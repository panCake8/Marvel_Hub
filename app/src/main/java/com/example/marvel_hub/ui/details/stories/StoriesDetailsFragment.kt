package com.example.marvel_hub.ui.details.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentStoriesDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.stories.adapter.ParentStoriesDetailsAdapter
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesDetailsFragment :
    BaseFragment<FragmentStoriesDetailsBinding, StoriesDetailsViewModel>() {

    override val viewModel: StoriesDetailsViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_stories_details
   private val argument: StoriesDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getAllData()
        observeEvents()
    }


    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentStoriesDetailsAdapter(viewModel, this)
    }

    private fun getAllData() {
        viewModel.getAllDataById(argument.id)
    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToCharacterDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToEventsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToComicsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                StoriesDetailsFragmentDirections.actionStoriesDetailsFragmentToSeriesDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })
    }

}