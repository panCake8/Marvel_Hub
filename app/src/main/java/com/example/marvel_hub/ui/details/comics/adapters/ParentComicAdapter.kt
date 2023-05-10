package com.example.marvel_hub.ui.details.comics.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsComicsBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsInfoBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharacterDetailsStoriesBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharcterDetailsEventsBinding
import com.example.marvel_hub.databinding.ItemRecyclerCharcterDetailsSeriesBinding

class ParentComicAdapter() :
    Adapter<ParentComicAdapter.BaseComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):BaseComicViewHolder {
        return when (viewType) {
            FIRST_ITEM -> InfoViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_recycler_character_details_info,
                    parent,
                    false
                )
            )

            SECOND_ITEM -> CharacterViewHolder(
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

    override fun onBindViewHolder(holder: BaseComicViewHolder, position: Int) {
        when (holder) {
            is InfoViewHolder -> bindInfo(holder.binding)
            is CharacterViewHolder -> bindComics(holder.binding)
            is SeriesViewHolder -> bindSeries(holder.binding)
            is EventsViewHolder -> bindEvents(holder.binding)
            is StoriesViewHolder -> bindStories(holder.binding)
        }
    }

    private fun bindInfo(binding: ItemRecyclerCharacterDetailsInfoBinding) {}
    private fun bindComics(binding: ItemRecyclerCharacterDetailsComicsBinding) {}
    private fun bindSeries(binding: ItemRecyclerCharcterDetailsSeriesBinding) {}
    private fun bindEvents(binding: ItemRecyclerCharcterDetailsEventsBinding) {}
    private fun bindStories(binding: ItemRecyclerCharacterDetailsStoriesBinding) {}


    abstract class BaseComicViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class InfoViewHolder(val binding: ItemRecyclerCharacterDetailsInfoBinding) :
        BaseComicViewHolder(binding)

    class EventsViewHolder(val binding: ItemRecyclerCharcterDetailsEventsBinding) :
        BaseComicViewHolder(binding)

    class SeriesViewHolder(val binding: ItemRecyclerCharcterDetailsSeriesBinding) :
        BaseComicViewHolder(binding)

    class CharacterViewHolder(val binding: ItemRecyclerCharacterDetailsComicsBinding) :
        BaseComicViewHolder(binding)

    class StoriesViewHolder(val binding: ItemRecyclerCharacterDetailsStoriesBinding) :
        BaseComicViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val SECOND_ITEM = 1
        const val THIRD_ITEM = 2
        const val FOURTH_ITEM = 3
        const val ITEMS_COUNT = 5

    }
}