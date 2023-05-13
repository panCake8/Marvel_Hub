package com.example.marvel_hub.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentHomeBinding
import com.example.marvel_hub.ui.HomeActivity
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.home.adapter.HomeAdapter
import com.example.marvel_hub.ui.home.viewModel.HomeViewModel
import com.example.marvel_hub.util.EventObserver

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    private lateinit var navController: NavController
    override val viewModel: HomeViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        transitionItems()
        transitionViewAll()
    }

    private fun initViews() {
        val adapter = HomeAdapter(viewModel)
        binding.recyclerHome.adapter = adapter
    }


    private fun transitionItems() {
        viewModel.selectedCharacterItem.observe(viewLifecycleOwner, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(it!!)
            findNavController().navigate(action)
        })
        viewModel.selectedComicItem.observe(viewLifecycleOwner, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToComicsDetailsFragment(it!!)
            findNavController().navigate(action)
        })
        viewModel.selectedSeriesItem.observe(viewLifecycleOwner, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToSeriesDetailsFragment(it!!)
            findNavController().navigate(action)
        })
        viewModel.selectedEventItem.observe(viewLifecycleOwner, EventObserver {
            val action = HomeFragmentDirections.actionHomeFragmentToEventsDetailsFragment(it!!)
            findNavController().navigate(action)
        })
    }

    private fun transitionViewAll() {
        viewModel.selectedComicViewAll.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.action_homeFragment_to_comicFragment)
        })
        viewModel.selectedCharacterViewAll.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.action_homeFragment_to_characterFragment)
        })
        viewModel.selectedEventViewAll.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.action_homeFragment_to_eventsSeeAllFragment)
        })
        viewModel.selectedSeriesViewAll.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(R.id.action_homeFragment_to_seriesFragment)
        })
    }

    override fun onResume() {
        super.onResume()
        navController = requireActivity().findNavController(R.id.fragment_container)
        binding.navBottom.setupWithNavController(navController)
    }
}