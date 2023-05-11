package com.example.marvel_hub.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentHomeBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.home.adapter.HomeAdapter
import com.example.marvel_hub.ui.home.viewModel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomeAdapter(mutableListOf(), viewModel)
        binding.recyclerHome.adapter = adapter
    }
}