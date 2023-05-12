package com.example.marvel_hub.ui.comics.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.comics.adapter.OnClickItemComic
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ComicsViewModel() : BaseViewModel(), OnClickItemComic {

    private val _comics = MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _comics


    private val _selectedComicItem = MutableLiveData<Event<ComicModel>>()
    val selectedComicItem: LiveData<Event<ComicModel>>
        get() = _selectedComicItem

    init {
        getComics()
    }

    private fun getComics() {
        repository.getAllComics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFaild)
            .addTo(compositeDisposable = disposable)

    }

    fun onSuccess(comicsResponse: BaseResponse<ComicModel>) {
        _comics.postValue(DataState.Success(comicsResponse))
    }

    fun onFaild(message: Throwable) {
        _comics.postValue(message.localizedMessage?.let { DataState.Error(it) })
    }

    override fun onClickItemComic(comic: ComicModel) {
        _selectedComicItem.postValue(Event(comic))
    }


}
