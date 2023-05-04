package com.example.marvel_hub.ui.search

import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel

class SearchFragment: BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_search
}