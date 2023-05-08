package com.example.marvel_hub.ui.details.character

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentCharacterDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment

class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {
    override val viewModel : CharacterDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        const val FIRST_Item = 0
        const val SCONDE_Item = 1
    }

}