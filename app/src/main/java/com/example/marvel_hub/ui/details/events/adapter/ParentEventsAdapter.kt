package com.example.marvel_hub.ui.details.events.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ItemRecyclerEventDetailsCharactersBinding
import com.example.marvel_hub.databinding.ItemRecyclerEventDetailsComicsBinding
import com.example.marvel_hub.databinding.ItemRecyclerEventDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerEventDetailsSeriesBinding
import com.example.marvel_hub.databinding.ItemRecyclerEventDetailsStoriesBinding
import com.example.marvel_hub.ui.details.events.EventsDetailsViewModel

class ParentEventsAdapter(
    private val viewModel: EventsDetailsViewModel,
    private val viewLifeCycle: LifecycleOwner,
) : Adapter<ParentEventsAdapter.BaseEventViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseEventViewHolder {
        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_event_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> ComicViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_event_details_comics,
                    parent,
                    false
                )
            )

            THIRD_ITEM -> SeriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_event_details_series,
                    parent,
                    false
                )
            )

            FOURTH_ITEM -> StoriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_event_details_stories,
                    parent,
                    false
                )
            )

            else -> CharactersViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_event_details_characters,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount() = ITEMS_COUNT

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseEventViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindingInfo(holder.binding)
            is CharactersViewHolder -> bindingCharacter(holder.binding)
            is ComicViewHolder -> bindingComics(holder.binding)
            is SeriesViewHolder -> bindingSeries(holder.binding)
            is StoriesViewHolder -> bindingStories(holder.binding)

        }
    }


    private fun bindingInfo(binding: ItemRecyclerEventDetailsInfoBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
    }

    private fun bindingCharacter(binding: ItemRecyclerEventDetailsCharactersBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childCharacterRecycler.adapter = ChildEventsCharacterAdapter(listOf(), viewModel)
    }

    private fun bindingStories(binding: ItemRecyclerEventDetailsStoriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childStoryRecycler.adapter = ChildEventsStoriesAdapter(listOf(), viewModel)
    }

    private fun bindingComics(binding: ItemRecyclerEventDetailsComicsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childComicRecycler.adapter = ChildEventsComicsAdapter(listOf(), viewModel)
    }

    private fun bindingSeries(binding: ItemRecyclerEventDetailsSeriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childSeriesRecycler.adapter = ChildEventsSeriesAdapter(listOf(), viewModel)
    }


    class InfoViewHolder(val binding: ItemRecyclerEventDetailsInfoBinding) :
        BaseEventViewHolder(binding)

    class SeriesViewHolder(val binding: ItemRecyclerEventDetailsSeriesBinding) :
        BaseEventViewHolder(binding)

    class ComicViewHolder(val binding: ItemRecyclerEventDetailsComicsBinding) :
        BaseEventViewHolder(binding)

    class CharactersViewHolder(val binding: ItemRecyclerEventDetailsCharactersBinding) :
        BaseEventViewHolder(binding)

    class StoriesViewHolder(val binding: ItemRecyclerEventDetailsStoriesBinding) :
        BaseEventViewHolder(binding)


    abstract class BaseEventViewHolder(binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}