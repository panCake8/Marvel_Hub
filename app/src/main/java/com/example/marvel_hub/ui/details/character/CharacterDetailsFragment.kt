package com.example.marvel_hub.ui.details.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.details.character.adapters.ParentCharacterAdapter

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    val arguments: CharacterDetailsFragmentArgs by navArgs()
    override val viewModel: CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
        initArguments()
    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = ParentCharacterAdapter(viewModel, viewLifecycleOwner)
    }

    private fun initArguments() {
        // val characterId = arguments.characterId
        viewModel.getCharacterById(1009368)
        viewModel.getStoriesByCharacterId(1009368)
    }

}