package com.example.marvel_hub.ui.details.comics


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.comics.adapter.ParentComicAdapter
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsDetailsFragment : BaseFragment<FragmentComicsDetailsBinding, ComicsDetailsViewModel>() {

    override val viewModel: ComicsDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_comics_details
    private val arguments: ComicsDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getAllData()
        observeEvents()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentComicAdapter(viewModel, viewLifecycleOwner)
    }

    private fun getAllData() {
        viewModel.getAllDataById(arguments.id)
    }

    private fun observeEvents() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                ComicsDetailsFragmentDirections.actionComicsDetailsFragmentToCharacterDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                ComicsDetailsFragmentDirections.actionComicsDetailsFragmentToEventsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                ComicsDetailsFragmentDirections.actionComicsDetailsFragmentToSeriesDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.storiesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                ComicsDetailsFragmentDirections.actionComicsDetailsFragmentToStoriesDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })
    }
}