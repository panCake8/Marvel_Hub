package com.example.marvel_hub.ui.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.comics.adapter.ComicsAdapter
import com.example.marvel_hub.ui.comics.viewModel.ComicsViewModel
import com.example.marvel_hub.util.EventObserver

class FragmentComics : BaseFragment<FragmentComicsBinding, ComicsViewModel>() {

    override val viewModel: ComicsViewModel by viewModels()

    override val layoutId: Int get() = R.layout.fragment_comics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.selectedComicItem.observe(viewLifecycleOwner,EventObserver{
            //Todo
        })
    }

    fun setupRecyclerView(){
        val adapter = ComicsAdapter(mutableListOf(), viewModel)
        binding.recyclerComics.adapter = adapter
    }

}