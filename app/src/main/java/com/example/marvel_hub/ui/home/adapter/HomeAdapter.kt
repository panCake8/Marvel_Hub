package com.example.marvel_hub.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.marvel_hub.BR
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.databinding.ListComicsBinding
import com.example.marvel_hub.databinding.ListEventsBinding
import com.example.marvel_hub.databinding.ListSeriesBinding
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener
import com.example.marvel_hub.ui.home.util.HomeItem

class HomeAdapter(
    private val listener: HomeInteractionListener,
) : BaseNestedAdapter<HomeItem>(listener) {

    override val layoutId = 0
    private fun getTypeView(item: HomeItem): Int {
        return when (item) {
            is HomeItem.Comics -> COMICS
            is HomeItem.Events -> EVENTS
            is HomeItem.Series -> SERIES

        }
    }

    override fun getItemViewType(position: Int): Int {
        return getTypeView(getItems()[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(newItems: List<HomeItem>) {
        setItems(newItems.sortedBy { it.rank })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {

            COMICS -> {
                val binding = DataBindingUtil.inflate<ListComicsBinding>(
                    inflater,
                    R.layout.list_comics,
                    parent,
                    false
                )
                ComicViewHolder(binding)
            }

            EVENTS -> {
                val binding = DataBindingUtil.inflate<ListEventsBinding>(
                    inflater,
                    R.layout.list_events,
                    parent,
                    false
                )
                EventViewHolder(binding)
            }

            else -> {
                val binding = DataBindingUtil.inflate<ListSeriesBinding>(
                    inflater,
                    R.layout.list_series,
                    parent,
                    false
                )
                SeriesViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (val current = getItems()[position]) {
            is HomeItem.Events -> bindEvent(current.data, holder as EventViewHolder)
            is HomeItem.Comics -> bindComic(current.data, holder as ComicViewHolder)
            is HomeItem.Series -> bindSeries(current.data, holder as SeriesViewHolder)
        }

    }

    private fun bindComic(current: List<ComicModel>, holder: ComicViewHolder) {
        val adapterRecycler = HomeComicsAdapter(listener)
        adapterRecycler.setItems(current)
        holder.binding.setVariable(BR.adapterRecycler, adapterRecycler)

    }

    private fun bindEvent(current: List<EventModel>, holder: EventViewHolder) {
        val adapterRecycler = HomeEventsAdapter(listener)
        adapterRecycler.setItems(current)
        holder.binding.setVariable(BR.adapterRecycler, adapterRecycler)

    }

    private fun bindSeries(current: List<SeriesModel>, holder: SeriesViewHolder) {
        val adapterRecycler = HomeSeriesAdapter(listener)
        adapterRecycler.setItems(current)
        holder.binding.setVariable(BR.adapterRecycler, adapterRecycler)

    }

    companion object {
        private const val COMICS = 1
        private const val EVENTS = 2
        private const val SERIES = 3
    }
}


class ComicViewHolder(
    val binding: ListComicsBinding
) : BaseNestedAdapter.BaseViewHolder(binding)

class EventViewHolder(
    val binding: ListEventsBinding
) : BaseNestedAdapter.BaseViewHolder(binding)

class SeriesViewHolder(
    val binding: ListSeriesBinding
) : BaseNestedAdapter.BaseViewHolder(binding)

