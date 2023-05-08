package com.example.marvel_hub.util

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.data.util.DataState

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
        (view.adapter as BaseAdapter<T>).setItems(items)
    } else {
        (view.adapter as BaseAdapter<T>).setItems(listOf())
    }
}