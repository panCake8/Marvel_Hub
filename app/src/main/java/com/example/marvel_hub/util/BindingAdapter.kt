package com.example.marvel_hub.util

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.marvel_hub.ui.util.UiState

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