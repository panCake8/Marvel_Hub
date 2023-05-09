package com.example.marvel_hub.ui.details.comics


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentComicsDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment


class ComicsDetailsFragment : BaseFragment<FragmentComicsDetailsBinding,ComicsDetailsViewModel>() {
    override val viewModel : ComicsDetailsViewModel by viewModels()
    override val layoutId = R.layout.fragment_character_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}