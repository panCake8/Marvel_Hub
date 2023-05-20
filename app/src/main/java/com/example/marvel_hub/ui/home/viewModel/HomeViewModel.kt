package com.example.marvel_hub.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.home.adapter.intreactions.HomeInteractionListener
import com.example.marvel_hub.ui.home.util.HomeItem
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: IMarvelRepository,
): BaseViewModel(), HomeInteractionListener {
    init {
        getHomeItems()
    }

    private val _homeItem = MutableLiveData<State<HomeItem>>(State.Loading)
    val homeItem: LiveData<State<HomeItem>> get() = _homeItem


    private val _selectedComicItem = MutableLiveData<Event<Int?>>()
    val selectedComicItem: LiveData<Event<Int?>> get() = _selectedComicItem

    private val _selectedCharacterItem = MutableLiveData<Event<Int?>>()
    val selectedCharacterItem: LiveData<Event<Int?>> get() = _selectedCharacterItem

    private val _selectedEventItem = MutableLiveData<Event<Int?>>()
    val selectedEventItem: LiveData<Event<Int?>> get() = _selectedEventItem

    private val _selectedSeriesItem = MutableLiveData<Event<Int?>>()
    val selectedSeriesItem: LiveData<Event<Int?>> get() = _selectedSeriesItem


    private val _selectedComicViewAll = MutableLiveData<Event<Unit>>()
    val selectedComicViewAll: LiveData<Event<Unit>> get() = _selectedComicViewAll

    private val _selectedCharacterViewAll = MutableLiveData<Event<Unit>>()
    val selectedCharacterViewAll: LiveData<Event<Unit>> get() = _selectedCharacterViewAll

    private val _selectedEventViewAll = MutableLiveData<Event<Unit>>()
    val selectedEventViewAll: LiveData<Event<Unit>> get() = _selectedEventViewAll

    private val _selectedSeriesViewAll = MutableLiveData<Event<Unit>>()
    val selectedSeriesViewAll: LiveData<Event<Unit>> get() = _selectedSeriesViewAll


    private fun getHomeItems() {
        repository.fetchHomeItems()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(homeItems: List<HomeItem>) {
        _homeItem.postValue(State.Success(homeItems))
    }

    private fun onError(error: Throwable) {
        _homeItem.postValue(State.Error(error.message.toString()))
    }

    override fun onEventItemClick(eventItem: EventModel) {
        _selectedEventItem.postValue(Event(eventItem.id))
    }

    override fun onComicItemClick(comicItem: ComicModel) {
        _selectedComicItem.postValue(Event(comicItem.id))
    }

    override fun onCharacterItemClick(characterItem: CharactersModel) {
        _selectedCharacterItem.postValue(Event(characterItem.id))
        Log.i("KAMEL", "Adsadas")
    }

    override fun onSeriesItemClick(seriesItem: SeriesModel) {
        _selectedSeriesItem.postValue(Event(seriesItem.id))
    }

    override fun onEventViewAllClick() {
        _selectedEventViewAll.postValue(Event(Unit))
    }

    override fun onComicViewAllClick() {
        _selectedComicViewAll.postValue(Event(Unit))
    }

    override fun onCharacterViewAllClick() {
        _selectedCharacterViewAll.postValue(Event(Unit))
    }

    override fun onSeriesViewAllClick() {
        _selectedSeriesViewAll.postValue(Event(Unit))
    }

}