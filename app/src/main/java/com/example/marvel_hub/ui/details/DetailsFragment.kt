package com.example.marvel_hub.ui.details

import android.os.Bundle
import android.view.View
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {
    override val viewModel = DetailsViewModel()
    override val layoutId = R.layout.fragment_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}