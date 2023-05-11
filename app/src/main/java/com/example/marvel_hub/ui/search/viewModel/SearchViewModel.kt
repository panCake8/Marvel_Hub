package com.example.marvel_hub.ui.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
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

    private val _dataType =
        MutableLiveData<Int>()
    val dataType: LiveData<Int> = _dataType


    private val _searchResult =
        MutableLiveData<DataState<BaseResponse<SearchItems>>>(DataState.Loading)
    val searchResult: LiveData<DataState<BaseResponse<SearchItems>>> = _searchResult




    private fun search(text: String) {
        disposable.add(
            repository.fetchSearchItems(text,text,text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetComicsSuccess, ::onGetComicsError)
        )
    }

    private fun onGetComicsSuccess(result: BaseResponse<SearchItems>) =
        _searchResult.postValue(DataState.Success(result))

    private fun onGetComicsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    fun onClickComicChip() {
        _dataType.postValue(1)
    }

    fun onClickEventChip() {
        _dataType.postValue(2)
    }

    fun onClickCreatorChip() {
        _dataType.postValue(3)
    }


    override fun onClickComic(comic: ComicModel) {

    }


    override fun onClickEvent(event: EventModel) {

    }

    override fun onClickSeries(creator: SeriesModel) {
    }
}

