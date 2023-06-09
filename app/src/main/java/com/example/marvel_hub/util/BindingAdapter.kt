package com.example.marvel_hub.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_hub.ui.adapters.CharacterAdapter
import com.example.marvel_hub.ui.adapters.ComicsAdapter
import com.example.marvel_hub.ui.adapters.EventsAdapter
import com.example.marvel_hub.ui.adapters.SeriesAdapter
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.HomeAdapter
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.ui.search.SearchStatus
import com.example.marvel_hub.ui.search.SearchViewModel
import com.example.marvel_hub.ui.search.adapters.CharacterSearchAdapter
import com.example.marvel_hub.ui.search.adapters.ComicsSearchAdapter
import com.example.marvel_hub.ui.search.adapters.EventsSearchAdapter
import com.example.marvel_hub.ui.search.adapters.SeriesSearchAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {

    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {

    if (state is State.Error)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}


@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {

    if (state is State.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}
@BindingAdapter(value = ["app:showWhenStart"])
fun <T> showWhenStart(view: View, state: State<T>?) {

    if (state is State.Success || state is State.Loading )
        view.visibility = View.GONE
    else
        view.visibility = View.VISIBLE

}
@BindingAdapter(value = ["app:showWhenNoResult"])
fun <T> showWhenNoResult(view: View, items: List<T>?) {
    if (items !=null && items.isEmpty())
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}


@BindingAdapter(value = ["app:recyclerItems"])
fun <T> setRecyclerItems(recyclerView: RecyclerView, items: List<T>?) {
    if (items != null) {
        (recyclerView.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (recyclerView.adapter as BaseAdapter<T>?)?.setItems(listOf())
    }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

@BindingAdapter(value = ["app:nestedRecyclerItems"])
fun setNestedRecyclerItems(recyclerView: RecyclerView, items: State<HomeItem>?) {
    items?.let {
        if (items is State.Success) {
            (recyclerView.adapter as HomeAdapter).addItem(items.data as MutableList<HomeItem>)
        }
    }
}

@BindingAdapter(value = ["app:setSearchAdapter", "app:setSearchStatus"])
fun setSearchRecyclerAdapter(
    view: RecyclerView,
    viewModel: SearchViewModel,
    searchStatus: SearchStatus
) {
    when (searchStatus) {
        SearchStatus.COMIC -> {
            val adapter = ComicsSearchAdapter(listOf(), viewModel)
            view.adapter = adapter
        }

        SearchStatus.EVENT -> {
            val adapter = EventsSearchAdapter(listOf(), viewModel)
            view.adapter = adapter
        }

        SearchStatus.SERIES -> {
            val adapter = SeriesSearchAdapter(listOf(), viewModel)
            view.adapter = adapter
        }

        else -> {
            val adapter = CharacterSearchAdapter(listOf(), viewModel)
            view.adapter = adapter
        }
    }
}
@BindingAdapter(value = ["app:availableItemsVisibility"])
fun setAvailableItemsVisibility(view: View, state: State<*>?) {
    val availableItem = state?.let { it.toData() }
    view.visibility = if (availableItem != null) View.VISIBLE else View.GONE
}

@BindingAdapter(value = ["visibilityIfNotBlank"])
fun visibilityIfNotBlank(view: View, text: String?) {
    if (text.isNullOrEmpty()) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}
