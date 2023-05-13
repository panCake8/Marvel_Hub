package com.example.marvel_hub.ui.details.character

import android.app.usage.UsageEvents.Event
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.character.adapters.ParentCharacterAdapter

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    override val viewModel: CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        observeEvents()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentCharacterAdapter(viewModel, viewLifecycleOwner)
    }
    private fun observeEvents() {
        viewModel.characterDetails.observe(viewLifecycleOwner) { clickEvent ->
            when (clickEvent) {
//                is CharacterDetailsEvents.ClickEventEvent -> navigateToEventsDetails(clickEvent.event)
//                is CharacterDetailsEvents.ClickComicEvent -> navigateToComicDetails(clickEvent.comic)
//                is CharacterDetailsEvents.ClickSeriesEvent -> navigateToSeriesDetails(clickEvent.series)
                else -> {}
            }
            viewModel.clearEvents()
        }
    }

    private fun initArguments() {
        // val characterId = arguments.characterId
        viewModel.getCharacterById(0)
        viewModel.getStoriesByCharacterId(0)
        viewModel.getEventsByCharacterId(0)
        viewModel.getComicsByCharacterId(0)
        viewModel.getSeriesByCharacterId(0)
    }

}