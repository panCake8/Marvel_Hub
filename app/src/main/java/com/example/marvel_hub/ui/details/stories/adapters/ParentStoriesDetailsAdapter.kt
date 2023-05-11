package com.example.marvel_hub.ui.details.stories.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerStoriesDetailsCharactersBinding
import com.example.marvel_hub.databinding.ItemRecyclerStoriesDetailsComicsBinding
import com.example.marvel_hub.databinding.ItemRecyclerStoriesDetailsEventsBinding
import com.example.marvel_hub.databinding.ItemRecyclerStoriesDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerStoriesDetailsSeriesBinding
import com.example.marvel_hub.ui.details.stories.StoriesDetailsViewModel

class ParentStoriesDetailsAdapter(
    val viewModel: StoriesDetailsViewModel,
    val lifecycleOwner: LifecycleOwner,
) :
    Adapter<ParentStoriesDetailsAdapter.BaseStoriesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseStoriesViewHolder {


        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_stories_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> ComicsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_stories_details_comics,
                    parent,
                    false
                )
            )

            THIRD_ITEM -> SeriesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_stories_details_series,
                    parent,
                    false
                )
            )

            FOURTH_ITEM -> CharactersVIewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_stories_details_characters,
                    parent,
                    false
                )
            )


            else -> EventsViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_stories_details_events,
                    parent,
                    false
                )
            )

        }

    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: BaseStoriesViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindInfo(holder.binding)
            is EventsViewHolder -> bindEvents(holder.binding)
            is ComicsViewHolder -> bindComics(holder.binding)
            is SeriesViewHolder -> bindSeries(holder.binding)
            is CharactersVIewHolder -> bindCharacters(holder.binding)
            else -> throw IllegalArgumentException("invalid Item")
        }
    }


    private fun bindInfo(binding: ItemRecyclerStoriesDetailsInfoBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner
    }

    private fun bindEvents(binding: ItemRecyclerStoriesDetailsEventsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner
//        binding.childEventRecycler.adapter=ChildStoriesEventsAdapter()
    }

    private fun bindComics(binding: ItemRecyclerStoriesDetailsComicsBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner
//        binding.childComicRecycler.adapter=ChildStoriesComicsAdapter()
    }

    private fun bindSeries(binding: ItemRecyclerStoriesDetailsSeriesBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner
//        binding.childSeriesRecycler.adapter=ChildStoriesSeriesAdapter()
    }

    private fun bindCharacters(binding: ItemRecyclerStoriesDetailsCharactersBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = lifecycleOwner
//        binding.childCharacterRecycler.adapter=ChildStoriesCharactersAdapter()
    }

    abstract class BaseStoriesViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)

    class InfoViewHolder(val binding: ItemRecyclerStoriesDetailsInfoBinding) :
        BaseStoriesViewHolder(binding)

    class EventsViewHolder(val binding: ItemRecyclerStoriesDetailsEventsBinding) :
        BaseStoriesViewHolder(binding)

    class ComicsViewHolder(val binding: ItemRecyclerStoriesDetailsComicsBinding) :
        BaseStoriesViewHolder(binding)

    class SeriesViewHolder(val binding: ItemRecyclerStoriesDetailsSeriesBinding) :
        BaseStoriesViewHolder(binding)

    class CharactersVIewHolder(val binding: ItemRecyclerStoriesDetailsCharactersBinding) :
        BaseStoriesViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}


