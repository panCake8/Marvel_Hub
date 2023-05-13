package com.example.marvel_hub.ui.details.character

import android.app.usage.UsageEvents.Event
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.character.adapters.ParentCharacterAdapter
import com.example.marvel_hub.util.EventObserver

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    override val viewModel: CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
        setUpTransition()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentCharacterAdapter(viewModel, viewLifecycleOwner)
    }
    private fun setUpTransition() {
        viewModel.comicEvent.observe(viewLifecycleOwner, EventObserver{
            if (it != null){

            }
        })
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