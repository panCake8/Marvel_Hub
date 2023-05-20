package com.example.marvel_hub.ui.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsBinding
import com.example.marvel_hub.ui.adapters.ComicsAdapter
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicFragment : BaseFragment<FragmentComicsBinding, ComicViewModel>() {

    override val viewModel: ComicViewModel by viewModels()
    override val layoutId = R.layout.fragment_comics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeEvent()
    }

    private fun setupRecyclerView() {
        val adapter = ComicsAdapter(mutableListOf(), viewModel)
        binding.recyclerComics.adapter = adapter
    }

    private fun observeEvent() {
        viewModel.selectedComicItem.observe(viewLifecycleOwner, EventObserver {
            val nav = ComicFragmentDirections.actionComicFragmentToComicsDetailsFragment(it!!)
            findNavController().navigate(nav)

        })
    }
}