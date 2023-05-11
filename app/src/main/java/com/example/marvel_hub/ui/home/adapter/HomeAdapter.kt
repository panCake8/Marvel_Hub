package com.example.marvel_hub.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.marvel_hub.BR
import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.databinding.ItemBannerBinding
import com.example.marvel_hub.databinding.ItemQuizBinding
import com.example.marvel_hub.databinding.ListComicsBinding
import com.example.marvel_hub.databinding.ListEventsBinding
import com.example.marvel_hub.databinding.ListSeriesBinding
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeComicInteractionsListener
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeEventInteractionsListener
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeSeriesInteractionsListener
import com.example.marvel_hub.ui.home.util.HomeItem

class HomeAdapter(
    private var items: List<HomeItem>,
    private val listener: BaseAdapterListener,
) : BaseAdapter<HomeItem>(items, listener) {
    override val getLayoutId: Int
        get() = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            BANNER -> {
                val binding = DataBindingUtil.inflate<ItemBannerBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_banner,
                    parent,
                    false
                )
                BannerViewHolder(binding)
            }

            COMICS -> {
                val binding = DataBindingUtil.inflate<ListComicsBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.list_comics,
                    parent,
                    false
                )
                ComicViewHolder(binding, listener as HomeComicInteractionsListener)
            }

            EVENTS -> {
                val binding = DataBindingUtil.inflate<ListEventsBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.list_events,
                    parent,
                    false
                )
                EventViewHolder(binding, listener as HomeEventInteractionsListener)
            }

            SERIES -> {
                val binding = DataBindingUtil.inflate<ListSeriesBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.list_series,
                    parent,
                    false
                )
                SeriesViewHolder(binding, listener as HomeSeriesInteractionsListener)
            }

            else -> {
                val binding = DataBindingUtil.inflate<ItemQuizBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_quiz,
                    parent,
                    false
                )
                QuizGameBannerViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeItem.Banner -> BANNER
            is HomeItem.Comics -> COMICS
            is HomeItem.Events -> EVENTS
            is HomeItem.Series -> SERIES
            else -> QUIZ_GAME_BANNER
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        bindItem(holder, items[position])
    }


    private fun bindItem(holder: BaseViewHolder, item: HomeItem) {
        when (item) {
            is HomeItem.Banner -> {
                (holder as BannerViewHolder).bind()
            }

            is HomeItem.Comics -> {
                (holder as ComicViewHolder).bind(item.data)
            }

            is HomeItem.Events -> {
                (holder as EventViewHolder).bind(item.data)
            }

            is HomeItem.Series -> {
                (holder as SeriesViewHolder).bind(item.data)
            }

            is HomeItem.QuizGameBanner -> (holder as QuizGameBannerViewHolder)
        }
    }

    override fun setItems(newItems: List<HomeItem>) {
        items = newItems
        items.apply {
            sortedBy(::sortItem)
        }
    }

    private fun sortItem(item: HomeItem) = item.rank


    companion object {
        private const val BANNER = 0
        private const val COMICS = 1
        private const val EVENTS = 2
        private const val SERIES = 3
        private const val QUIZ_GAME_BANNER = 4
    }
}

class ComicViewHolder(
    private val binding: ListComicsBinding,
    private val listener: HomeComicInteractionsListener
) :
    BaseAdapter.BaseViewHolder(binding) {
    fun bind(items: List<ComicModel>) {
        binding.setVariable(BR.adapterRecycler, HomeComicsAdapter(items, listener))
        binding.setVariable(BR.listener, listener)
    }
}

class EventViewHolder(
    private val binding: ListEventsBinding,
    private val listener: HomeEventInteractionsListener
) :
    BaseAdapter.BaseViewHolder(binding) {
    fun bind(items: List<EventModel>) {
        binding.setVariable(BR.adapterRecycler, HomeEventsAdapter(items, listener))
        binding.setVariable(BR.listener, listener)
    }
}

class SeriesViewHolder(
    private val binding: ListSeriesBinding,
    private val listener: HomeSeriesInteractionsListener
) :
    BaseAdapter.BaseViewHolder(binding) {
    fun bind(items: List<SeriesModel>) {
        binding.setVariable(BR.adapterRecycler, HomeSeriesAdapter(items, listener))
        binding.setVariable(BR.listener, listener)
    }
}

class BannerViewHolder(private val binding: ItemBannerBinding) :
    BaseAdapter.BaseViewHolder(binding) {
    fun bind() {
        binding.imageBanner.visibility = View.VISIBLE
    }
}

class QuizGameBannerViewHolder(binding: ItemQuizBinding) : BaseAdapter.BaseViewHolder(binding)