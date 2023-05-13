package com.example.marvel_hub.ui.details.character

import android.app.usage.UsageEvents.Event
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.character.adapters.ParentCharacterAdapter
import com.example.marvel_hub.ui.details.comics.ComicsDetailsFragmentArgs
import com.example.marvel_hub.ui.details.comics.ComicsDetailsFragmentDirections
import com.example.marvel_hub.util.EventObserver

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    override val viewModel: CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details
    val arguments: ComicsDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        observeEvents()
        backClick()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentCharacterAdapter(viewModel, viewLifecycleOwner)
    }
    private fun backClick(){
        binding.toolbarCharacterDetails.setNavigationOnClickListener{
            findNavController().popBackStack()
        }
    }

    private fun initArguments() {
        viewModel.getCharacterById(arguments.id)
        viewModel.getEventsByCharacterId(arguments.id)
        viewModel.getComicsByCharacterId(arguments.id)
        viewModel.getSeriesByCharacterId(arguments.id)
        viewModel.getStoriesByCharacterId(arguments.id)
    }
    private fun observeEvents() {

        viewModel.eventEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToEventsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.seriesEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToSeriesDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })

        viewModel.storyEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToComicsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToComicsDetailsFragment(
                        it.id!!
                    )
                findNavController().navigate(nav)
            }
        })
    }

}