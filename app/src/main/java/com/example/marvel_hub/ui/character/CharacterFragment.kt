package com.example.marvel_hub.ui.character

import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharactersBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.character.viewModel.CharacterViewModel

class CharacterFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>() {
    override val viewModel: CharacterViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_characters

}