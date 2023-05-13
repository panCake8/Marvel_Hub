package com.example.marvel_hub.ui.stories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentStoryBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.stories.adapter.StoriesAdapter
import com.example.marvel_hub.ui.stories.viewModel.StoryViewModel
import com.example.marvel_hub.util.EventObserver

class StoryFragment : BaseFragment<FragmentStoryBinding, StoryViewModel>() {

    override val viewModel: StoryViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_story

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.selectedStoryItem.observe(viewLifecycleOwner, EventObserver {
            //Todo
        })
    }

    private fun setupRecyclerView() {
        val adapter = StoriesAdapter(mutableListOf(), viewModel)
        binding.recyclerStory.adapter = adapter
    }
}