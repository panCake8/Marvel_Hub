package com.example.marvel_hub.ui.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.search.adapter.SearchItems
import com.example.marvel_hub.ui.search.adapter.interactions.ComicInteractionListener
import com.example.marvel_hub.ui.search.adapter.interactions.EventInteractionListener
import com.example.marvel_hub.ui.search.adapter.interactions.SeriesInteractionListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel : BaseViewModel(), EventInteractionListener,
    ComicInteractionListener,
    SeriesInteractionListener {

    val searchInput = MutableLiveData<String>()



    private val _dataType =
        MutableLiveData<Enum<Data>>()
    val dataType: LiveData<Enum<Data>> = _dataType


    private val _searchResult =
        MutableLiveData<DataState<List<SearchItems>>>(DataState.Loading)
    val searchResult: LiveData<DataState<List<SearchItems>>>
    get() = _searchResult


    private val _comics = MutableLiveData<DataState<List<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<List<ComicModel>>>
        get() = _comics


    private val _event = MutableLiveData<DataState<List<EventModel>>>(DataState.Loading)
    val event: LiveData<DataState<List<EventModel>>>
        get() = _event


    private val _series = MutableLiveData<DataState<List<SeriesModel>>>(DataState.Loading)
    val series: LiveData<DataState<List<SeriesModel>>>
        get() = _series

    private val _character = MutableLiveData<DataState<List<CharactersModel>>>(DataState.Loading)
    val character: LiveData<DataState<List<CharactersModel>>>
        get() = _character



    init {

    }

    private fun getComicData(text: String) {
        disposable.add(
            repository.searchComics(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetComicsSuccess, ::onGetComicsError)
        )
    }
    private fun onGetComicsSuccess(result: List<ComicModel>) =
        _comics.postValue(DataState.Success(result))

    private fun onGetComicsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())



    private fun getSeriesData(text: String) {
        disposable.add(
            repository.searchSeries(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetSeriesSuccess, ::onGetSeriesError)
        )
    }
   private fun onGetSeriesSuccess(series: List<SeriesModel>) =
        _series.postValue(DataState.Success(series))

    private fun onGetSeriesError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    private fun getEventData(text: String) {
        disposable.add(
            repository.searchEvents(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetEventSuccess, ::onGetEventError)
        )
    }
    private fun onGetEventSuccess(series: List<EventModel>) =
        _event.postValue(DataState.Success(series))

    private fun onGetEventError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())




    fun onClickComicChip() {
        _dataType.postValue(Data.COMIC)
    }

    fun onClickEventChip() {
        _dataType.postValue(Data.EVENT)
    }

    fun onClickSeriesChip() {
        _dataType.postValue(Data.SERIES)
    }


    override fun onClickComic(comic: ComicModel) {

    }


    override fun onClickEvent(event: EventModel) {

    }

    override fun onClickSeries(creator: SeriesModel) {
    }
}

