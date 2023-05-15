package com.example.marvel_hub.ui.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsBinding
import com.example.marvel_hub.ui.adapters.ComicsAdapter
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver

class ComicFragment : BaseFragment<FragmentComicsBinding, ComicViewModel>() {

    override val viewModel: ComicViewModel by viewModels()
    override val layoutId: Int get() = R.layout.fragment_comics

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        BackFromTheComicsToTheHome()
        viewModel.selectedComicItem.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    ComicFragmentDirections.actionComicFragmentToComicsDetailsFragment(
                        it
                    )
                findNavController().navigate(nav)
            }
        })
    }

    private fun BackFromTheComicsToTheHome() {
        binding.toolbarComics.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupRecyclerView() {
        val adapter = ComicsAdapter(mutableListOf(), viewModel)
        binding.recyclerComics.adapter = adapter
    }

}