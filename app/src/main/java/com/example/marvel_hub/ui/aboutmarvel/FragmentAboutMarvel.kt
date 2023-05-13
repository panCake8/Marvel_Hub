package com.example.marvel_hub.ui.aboutmarvel


import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentAboutMarvelBinding
import com.example.marvel_hub.ui.aboutmarvel.viewModel.AboutMarvelViewModel
import com.example.marvel_hub.ui.base.BaseFragment

class FragmentAboutMarvel : BaseFragment<FragmentAboutMarvelBinding, AboutMarvelViewModel>() {

    override val viewModel: AboutMarvelViewModel by viewModels()

    override val layoutId: Int get() = R.layout.fragment_about_marvel

}
