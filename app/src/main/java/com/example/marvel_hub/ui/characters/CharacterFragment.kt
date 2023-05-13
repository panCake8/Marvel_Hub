package com.example.marvel_hub.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharactersBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.characters.adapter.CharacterAdapter
import com.example.marvel_hub.ui.characters.viewModel.CharacterViewModel
import com.example.marvel_hub.util.EventObserver

class CharacterFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {

    override val viewModel: CharacterViewModel by viewModels()
    override val layoutId: Int get() = R.layout.fragment_characters

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        backClick()

        viewModel.selectedCharacterItem.observe(viewLifecycleOwner, EventObserver {
            if (it != null) {
                val nav =
                    CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailsFragment(
                        it
                    )
                findNavController().navigate(nav)
            }
        })
    }
    private fun backClick(){
        binding.toolbarCharacter.setNavigationOnClickListener{
            findNavController().popBackStack()
        }
    }
    private fun setupRecyclerView() {
        val adapter = CharacterAdapter(emptyList(), viewModel)
        binding.recyclerViewCharacters.adapter = adapter
    }

}
