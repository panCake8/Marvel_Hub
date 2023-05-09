package com.example.marvel_hub.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharactersBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.characters.adapter.CharacterAdapter
import com.example.marvel_hub.ui.characters.viewModel.CharacterViewModel
import com.example.marvel_hub.util.EventObserver

class FragmentCharacters : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {

    override val viewModel: CharacterViewModel by viewModels()
    override val layoutId: Int get() = R.layout.fragment_characters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(mutableListOf(), viewModel)
        binding.recyclerViewCharacters.adapter = adapter

        viewModel.eventCharacter.observe(viewLifecycleOwner, EventObserver {

        })
    }

}
