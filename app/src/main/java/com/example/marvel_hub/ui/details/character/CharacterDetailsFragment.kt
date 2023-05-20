package com.example.marvel_hub.ui.details.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.character.adapter.ParentCharacterAdapter
import com.example.marvel_hub.ui.details.comics.ComicsDetailsFragmentArgs
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    override val viewModel: CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details
    private val arguments: ComicsDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        getAllData()
        observeEvents()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentCharacterAdapter(viewModel, viewLifecycleOwner)
    }

    private fun getAllData() {
        viewModel.getAllDataById(arguments.id)
    }

    private fun observeEvents() {

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToEventsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToSeriesDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })

        viewModel.storyEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToComicsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })
        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToComicsDetailsFragment(
                    it.id!!
                )
            findNavController().navigate(nav)
        })
    }

}