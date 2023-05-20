package com.example.marvel_hub.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharactersBinding
import com.example.marvel_hub.ui.adapters.CharacterAdapter
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {

    override val viewModel: CharacterViewModel by viewModels()
    override val layoutId = R.layout.fragment_characters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeEvent()
    }

    private fun setupRecyclerView() {
        val adapter = CharacterAdapter(emptyList(), viewModel)
        binding.recyclerViewCharacters.adapter = adapter
    }

    private fun observeEvent() {
        viewModel.selectedCharacterItem.observe(viewLifecycleOwner, EventObserver {
            val nav =
                CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailsFragment(it!!)
            findNavController().navigate(nav)

        })
    }
}
