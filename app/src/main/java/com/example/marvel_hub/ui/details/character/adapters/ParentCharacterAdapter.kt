package com.example.marvel_hub.ui.details.character.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsComicsBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsStoriesBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharcterDetailsEventsBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharcterDetailsSeriesBinding
import com.example.marvel_hub.ui.details.character.CharacterDetailsViewModel

class ParentCharacterAdapter(
    val viewModel: CharacterDetailsViewModel,
    val viewLifeCycle: LifecycleOwner
) :
    Adapter<ParentCharacterAdapter.BaseCharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCharacterViewHolder {
        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_character_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> ComicViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_character_details_comics,
                    parent,
                    false
                )
            )

            THIRD_ITEM -> SeriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_charcter_details_series,
                    parent,
                    false
                )
            )

            FOURTH_ITEM -> StoriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_character_details_stories,
                    parent,
                    false
                )
            )

            else -> EventsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_charcter_details_events,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount() = ITEMS_COUNT

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseCharacterViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindInfo(holder.binding)
            is ComicViewHolder -> bindComics(holder.binding)
            is SeriesViewHolder -> bindSeries(holder.binding)
            is EventsViewHolder -> bindEvents(holder.binding)
            is StoriesViewHolder -> bindStories(holder.binding)
        }
    }

    private fun bindInfo(binding: ItemRecyclerCharacterDetailsInfoBinding) {
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifeCycle
    }

    private fun bindComics(binding: ItemRecyclerCharacterDetailsComicsBinding) {
        // binding.childComicRecycler.adapter = ChildCharacterComicsAdapter(listOf(), null)
    }

    private fun bindSeries(binding: ItemRecyclerCharcterDetailsSeriesBinding) {
        // binding.childSeriesRecycler.adapter = ChildCharacterSeriesAdapter(listOf(), null)
    }

    private fun bindEvents(binding: ItemRecyclerCharcterDetailsEventsBinding) {
        //  binding.childEventRecycler.adapter = ChildCharacterEventsAdapter(listOf(), null)
    }

    private fun bindStories(binding: ItemRecyclerCharacterDetailsStoriesBinding) {
        binding.viewModel = viewModel
        binding.childStoryRecycler.adapter = ChildCharacterStoriesAdapter(listOf(), null)
    }


    abstract class BaseCharacterViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class InfoViewHolder(val binding: ItemRecyclerCharacterDetailsInfoBinding) :
        BaseCharacterViewHolder(binding)

    class EventsViewHolder(val binding: ItemRecyclerCharcterDetailsEventsBinding) :
        BaseCharacterViewHolder(binding)

    class SeriesViewHolder(val binding: ItemRecyclerCharcterDetailsSeriesBinding) :
        BaseCharacterViewHolder(binding)

    class ComicViewHolder(val binding: ItemRecyclerCharacterDetailsComicsBinding) :
        BaseCharacterViewHolder(binding)

    class StoriesViewHolder(val binding: ItemRecyclerCharacterDetailsStoriesBinding) :
        BaseCharacterViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}