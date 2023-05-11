package com.example.marvel_hub.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeComicInteractionsListener
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeEventInteractionsListener
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionsListener
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeSeriesInteractionsListener
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel(), HomeEventInteractionsListener,
    HomeComicInteractionsListener, HomeInteractionsListener, HomeSeriesInteractionsListener {
    init {
        getHomeItems()
    }

    private val _homeItem = MutableLiveData<State<HomeItem>>(State.Loading)
    val homeItem: LiveData<State<HomeItem>> get() = _homeItem

    private fun getHomeItems() {
        repository.fetchHomeItems()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onError)
            .addTo(disposable)
    }

    private fun onSuccess(items: List<HomeItem>) {
        _homeItem.postValue(State.SuccessList(items))
    }

    private fun onError(error: Throwable) {
        _homeItem.postValue(State.Error(error.message.toString()))
    }

    override fun onClickHomeComicItem(comic: ComicModel) {

    }

    override fun onClickHomeEventItem(event: EventModel) {

    }

    override fun onClickHomeSeriesItem(series: SeriesModel) {

    }

    override fun onClickSeriesViewAll() {

    }

    override fun onClickComicsViewAll() {

    }

    override fun onClickEventsViewAll() {

    }
}