package com.example.marvel_hub.ui.search


import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel
import com.example.marvel_hub.util.EventObserver


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()



    override val layoutId = R.layout.fragment_search
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTransition()
    }


    private fun setUpTransition() {
        viewModel.characterEvent.observe(viewLifecycleOwner, EventObserver{
            if (it != null){

            }
        })
    }
}

