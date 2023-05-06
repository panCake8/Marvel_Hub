package com.example.marvel_hub.ui.details

import android.os.Bundle
import android.view.View
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentDetailsBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {
    override val viewModel = DetailsViewModel()
    override val layoutId = R.layout.fragment_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpVewPager()
    }

    private fun setUpVewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                FIRST_Item -> getString(R.string.comics)
                SCONDE_Item -> getString(R.string.series)
                else -> getString(R.string.events)
            }
        }.attach()

    }

    companion object {
        const val FIRST_Item = 0
        const val SCONDE_Item = 1
    }

}