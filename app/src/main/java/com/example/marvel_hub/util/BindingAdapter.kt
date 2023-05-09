package com.example.marvel_hub.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_hub.ui.base.BaseAdapter
import com.example.marvel_hub.ui.util.UiState
import okhttp3.HttpUrl

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, uiState: UiState<T>?) {

    if (uiState is UiState.Loading)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, uiState: UiState<T>?) {

    if (uiState is UiState.Error)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE

}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, uiState: UiState<T>?) {

    if (uiState is UiState.Success)
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

@BindingAdapter(value = ["app:imageUrl"])
fun setImageView(view: ImageView,url: String?){
    Glide.with(view).load(url).into(view)

}