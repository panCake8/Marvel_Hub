package com.example.marvel_hub.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.home.adapter.HomeAdapter
import com.example.marvel_hub.ui.home.util.HomeItem

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

@BindingAdapter(value = ["app:recyclerItems"])
fun <T> setRecyclerItems(recyclerView: RecyclerView, items: List<T>?) {
    if (items != null) {
        (recyclerView.adapter as BaseAdapter<T>).setItems(items)
    } else {
        (recyclerView.adapter as BaseAdapter<T>).setItems(listOf())
    }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

@BindingAdapter(value = ["app:nestedRecyclerItems"])
fun setNestedRecyclerItems(recyclerView: RecyclerView, items: State<HomeItem>?) {
    if (items != null)
        if (items is State.SuccessList) {
            items.toDataList()?.let { it1 -> (recyclerView.adapter as HomeAdapter).addItem(it1) }
        } else {
            (recyclerView.adapter as HomeAdapter).addItem(listOf())
        }
    else
        (recyclerView.adapter as HomeAdapter).addItem(listOf())

}