package com.example.marvel_hub.ui.details.comics.adapters

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
import com.example.marvel_hub.databinding.ItemRecyclerComicDetailsCharacterBinding
import com.example.marvel_hub.databinding.ItemRecyclerComicDetailsEventsBinding
import com.example.marvel_hub.databinding.ItemRecyclerComicDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerComicDetailsSeriesBinding
import com.example.marvel_hub.databinding.ItemRecyclerComicDetailsStoriesBinding
import com.example.marvel_hub.ui.details.character.CharacterDetailsViewModel
import com.example.marvel_hub.ui.details.character.adapters.ChildCharacterComicsAdapter
import com.example.marvel_hub.ui.details.character.adapters.ChildCharacterEventsAdapter
import com.example.marvel_hub.ui.details.character.adapters.ChildCharacterSeriesAdapter
import com.example.marvel_hub.ui.details.character.adapters.ChildCharacterStoriesAdapter
import com.example.marvel_hub.ui.details.comics.ComicsDetailsViewModel

class ParentComicAdapter(
    private val viewModel: ComicsDetailsViewModel,
    private val viewLifeCycle: LifecycleOwner,)
    :Adapter<ParentComicAdapter.BaseComicViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BaseComicViewHolder {
        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_comic_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> CharacterViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_comic_details_character,
                    parent,
                    false
                )
            )

            THIRD_ITEM -> SeriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_comic_details_series,
                    parent,
                    false
                )
            )

            FOURTH_ITEM -> StoriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_comic_details_stories,
                    parent,
                    false
                )
            )

            else -> EventsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_comic_details_events,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount() = ITEMS_COUNT

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseComicViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindInfo(holder.binding)
            is CharacterViewHolder -> bindCharacters(holder.binding)
            is SeriesViewHolder -> bindSeries(holder.binding)
            is EventsViewHolder -> bindEvents(holder.binding)
            is StoriesViewHolder -> bindStories(holder.binding)
        }
    }

    private fun bindInfo(binding:ItemRecyclerComicDetailsInfoBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
    }

    private fun bindCharacters(binding: ItemRecyclerComicDetailsCharacterBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childCharacterRecycler.adapter = ChildComicsCharacterAdapter(listOf(), viewModel)
    }

    private fun bindSeries(binding: ItemRecyclerComicDetailsSeriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childSeriesRecycler.adapter = ChildComicsSeriesAdapter(listOf(), viewModel)
    }

    private fun bindEvents(binding: ItemRecyclerComicDetailsEventsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childEventRecycler.adapter = ChildComicsEventsAdapter(listOf(), viewModel)
    }

    private fun bindStories(binding: ItemRecyclerComicDetailsStoriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifeCycle
        binding.childStoryRecycler.adapter = ChildComicsStoriesAdapter(listOf(), viewModel)
    }



    abstract class BaseComicViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class InfoViewHolder(val binding: ItemRecyclerComicDetailsInfoBinding) :
        BaseComicViewHolder(binding)

    class EventsViewHolder(val binding: ItemRecyclerComicDetailsEventsBinding) :
        BaseComicViewHolder(binding)

    class SeriesViewHolder(val binding: ItemRecyclerComicDetailsSeriesBinding) :
        BaseComicViewHolder(binding)

    class CharacterViewHolder(val binding: ItemRecyclerComicDetailsCharacterBinding) :
        BaseComicViewHolder(binding)

    class StoriesViewHolder(val binding: ItemRecyclerComicDetailsStoriesBinding) :
        BaseComicViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}