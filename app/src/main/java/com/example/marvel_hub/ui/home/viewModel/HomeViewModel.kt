package com.example.marvel_hub.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel(), HomeInteractionListener {
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

    override fun onEventItemClick(id: Int) {

    }

    override fun onComicItemClick(id: Int) {

    }

    override fun onCharacterItemClick(id: Int) {

    }
}