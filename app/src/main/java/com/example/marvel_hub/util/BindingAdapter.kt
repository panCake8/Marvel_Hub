package com.example.marvel_hub.util

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.search.adapter.SearchComicsAdapter
import com.example.marvel_hub.ui.search.adapter.SearchEventAdapter
import com.example.marvel_hub.ui.search.adapter.SearchSeriesAdapter
import com.example.marvel_hub.ui.search.viewModel.SearchStatus
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, dataState: DataState<T>?) {

    if (dataState is DataState.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, dataState: DataState<T>?) {

    if (dataState is DataState.Error)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, dataState: DataState<T>?) {

    if (dataState is DataState.Success)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:recyclerItems"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    if (items != null) {
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>?)?.setItems(listOf())
    }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

@SuppressLint("CheckResult")
@BindingAdapter(value = ["app:onSearchTextChange"])
fun onSearchTextChange(view: EditText, viewModel: SearchViewModel) {
    Observable.create { emitter ->
        view.doOnTextChanged { text, start, before, count ->
            emitter.onNext(text.toString())
        }
    }.debounce(1, TimeUnit.SECONDS).observeOn(Schedulers.io())
        .subscribeOn(AndroidSchedulers.mainThread()).subscribe { text ->
            if (text.isNotEmpty()) {
                when (viewModel.searchStatus.value) {
                    SearchStatus.COMIC -> viewModel.getComicData(text)
                    SearchStatus.EVENT -> viewModel.getEventData(text)
                    else -> viewModel.getSeriesData(text)
                }
            }
        }
}

@BindingAdapter(value = ["app:setSearchAdapter" , "app:setSearchStatus"])
fun setSearchRecyclerAdapter(
    view: RecyclerView,
    viewModel: SearchViewModel,
    searchStatus : SearchStatus
) {
    when (searchStatus) {
        SearchStatus.COMIC -> {
            val adapter = SearchComicsAdapter(listOf(), viewModel)
            view.adapter = adapter
        }

        SearchStatus.EVENT -> {
            val adapter = SearchEventAdapter(listOf(), viewModel)
            view.adapter = adapter
        }

        else -> {
            val adapter = SearchSeriesAdapter(listOf(), viewModel)
            view.adapter = adapter
        }
    }
}