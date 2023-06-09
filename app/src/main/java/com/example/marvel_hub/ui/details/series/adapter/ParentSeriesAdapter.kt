package com.example.marvel_hub.ui.details.series.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ItemRecyclerSeriesDetailsCharacterBinding
import com.example.marvel_hub.databinding.ItemRecyclerSeriesDetailsComicsBinding
import com.example.marvel_hub.databinding.ItemRecyclerSeriesDetailsEventsBinding
import com.example.marvel_hub.databinding.ItemRecyclerSeriesDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerSeriesDetailsStoriesBinding
import com.example.marvel_hub.ui.adapters.CharacterAdapter
import com.example.marvel_hub.ui.adapters.ComicsAdapter
import com.example.marvel_hub.ui.adapters.EventsAdapter
import com.example.marvel_hub.ui.adapters.StoriesAdapter
import com.example.marvel_hub.ui.details.series.SeriesDetailsViewModel

class ParentSeriesAdapter(
    private val viewModel: SeriesDetailsViewModel,
    private val viewLifeCycle: LifecycleOwner
) :
    Adapter<ParentSeriesAdapter.BaseSeriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseSeriesViewHolder {
        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_series_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> CharacterViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_series_details_character,
                    parent,
                    false
                )
            )

            THIRD_ITEM -> ComicViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_series_details_comics,
                    parent,
                    false
                )
            )

            FOURTH_ITEM -> StoriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_series_details_stories,
                    parent,
                    false
                )
            )

            else -> EventsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_series_details_events,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount() = ITEMS_COUNT

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseSeriesViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindInfo(holder.binding)
            is ComicViewHolder -> bindComics(holder.binding)
            is CharacterViewHolder -> bindCharacter(holder.binding)
            is EventsViewHolder -> bindEvents(holder.binding)
            is StoriesViewHolder -> bindStories(holder.binding)
        }
    }

    private fun bindInfo(binding: ItemRecyclerSeriesDetailsInfoBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
    }

    private fun bindComics(binding: ItemRecyclerSeriesDetailsComicsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childComicRecycler.adapter = ComicsAdapter(listOf(), viewModel)
    }

    private fun bindCharacter(binding: ItemRecyclerSeriesDetailsCharacterBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childCharaterRecycler.adapter = CharacterAdapter(listOf(), viewModel)
    }

    private fun bindEvents(binding: ItemRecyclerSeriesDetailsEventsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childEventRecycler.adapter = EventsAdapter(listOf(), viewModel)
    }

    private fun bindStories(binding: ItemRecyclerSeriesDetailsStoriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childStoryRecycler.adapter = StoriesAdapter(listOf(), viewModel)
    }


    abstract class BaseSeriesViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class InfoViewHolder(val binding: ItemRecyclerSeriesDetailsInfoBinding) :
        BaseSeriesViewHolder(binding)

    class EventsViewHolder(val binding: ItemRecyclerSeriesDetailsEventsBinding) :
        BaseSeriesViewHolder(binding)

    class CharacterViewHolder(val binding: ItemRecyclerSeriesDetailsCharacterBinding) :
        BaseSeriesViewHolder(binding)

    class ComicViewHolder(val binding: ItemRecyclerSeriesDetailsComicsBinding) :
        BaseSeriesViewHolder(binding)

    class StoriesViewHolder(val binding: ItemRecyclerSeriesDetailsStoriesBinding) :
        BaseSeriesViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}