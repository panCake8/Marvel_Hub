package com.example.marvel_hub.ui.aboutmarvel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentAboutMarvelBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.util.EventObserver

class FragmentAboutMarvel : BaseFragment<FragmentAboutMarvelBinding, AboutMarvelViewModel>() {

    override val viewModel: AboutMarvelViewModel by viewModels()

    override val layoutId: Int get() = R.layout.fragment_about_marvel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AboutMarvelAdapter(mutableListOf(), viewModel)
        binding.recyclerCharacters.adapter = adapter

        viewModel.selectedmarvelItem.observe(viewLifecycleOwner,EventObserver{
            //Todo
        })
    }



}