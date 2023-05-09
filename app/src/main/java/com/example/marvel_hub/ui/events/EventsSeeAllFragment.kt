package com.example.marvel_hub.ui.events

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.databinding.FragmentEventsSeeAllBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.events.viewModel.EventsViewModel
import com.example.marvel_hub.ui.events.event_recycler.EventsInteractionListener

class EventsSeeAllFragment :
    BaseFragment<FragmentEventsSeeAllBinding, EventsViewModel>(), EventsInteractionListener {


    override val viewModel: EventsViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_events_see_all


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()

    }


    fun setUp() {
//        val adapter = EventsSeeAllAdapter(emptyList(), this)
//        binding.recyclerEvents.adapter=adapter
        viewModel.fetchAllEvents()

    }

    override fun onClickListener(event: EventModel) {
//        val fragment = EventsDetails()
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .addToBackStack(null)
//            .commit()

    }

}