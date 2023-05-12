package com.example.marvel_hub.ui.search.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
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
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel : BaseViewModel(), EventInteractionListener,
    ComicInteractionListener,
    SeriesInteractionListener {

    val searchInput = MutableLiveData<String>()



    private val _search_stautsType =
        MutableLiveData<Enum<SearchStatus>>()
    val searchStatusType: LiveData<Enum<SearchStatus>> = _search_stautsType


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

     fun getComicData(text: String) {
        Log.i("testInputComic","$text")
         repository.searchComics(text)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(::onGetComicsSuccess, ::onGetComicsError).addTo(disposable)
    }
    private fun onGetComicsSuccess(result: BaseResponse<ComicModel>) =
        _comics.postValue(DataState.Success(result.data?.results!!))

    private fun onGetComicsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())



     fun getSeriesData(text: String) {
         Log.i("testInputSeries","$text")

         repository.searchSeries(text)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(::onGetSeriesSuccess, ::onGetSeriesError).addTo(disposable)
    }
   private fun onGetSeriesSuccess(series: BaseResponse<SeriesModel>) =
        _series.postValue(DataState.Success(series.data?.results!!))

    private fun onGetSeriesError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


     fun getEventData(text: String) {
         Log.i("testInputEvent","$text")

         repository.searchEvents(text)
             .subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(::onGetEventSuccess, ::onGetEventError).addTo(disposable)
    }
    private fun onGetEventSuccess(series: BaseResponse<EventModel>) =
        _event.postValue(DataState.Success(series.data?.results!!))

    private fun onGetEventError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    fun onClickComicChip() {

    }

    fun onClickEventChip() {
        _search_stautsType.postValue(SearchStatus.EVENT)
    }

    fun onClickSeriesChip() {
        _search_stautsType.postValue(SearchStatus.SERIES)
    }


    override fun onClickComic(comic: ComicModel) {

    }


    override fun onClickEvent(event: EventModel) {

    }

    override fun onClickSeries(creator: SeriesModel) {
    }
}

