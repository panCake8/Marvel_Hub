package com.example.marvel_hub.ui.details

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.marvel_hub.ui.details.view_pager_fragments.ComicsFragment
import com.example.marvel_hub.ui.details.view_pager_fragments.EventsFragment
import com.example.marvel_hub.ui.details.view_pager_fragments.SeriesFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = ITEMS_COUNT

    override fun createFragment(position: Int) = when (position) {
        FIRST_Item -> ComicsFragment()
        SCONDE_Item -> SeriesFragment()
        else -> EventsFragment()
    }

    companion object {
        const val FIRST_Item = 0
        const val SCONDE_Item = 1
        const val ITEMS_COUNT = 2
    }
}