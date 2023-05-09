package com.example.marvel_hub.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ComicsViewModel() : BaseViewModel(), onClickComic {

    private val _Comics = MutableLiveData<DataState<BaseResponse<ComicModel>>>()
    val comics: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _Comics


   private val _selectedComicsItem = MutableLiveData<Event<ComicModel>>()
    val selectedComicsItem: LiveData<Event<ComicModel>>
        get() = _selectedComicsItem

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
        _Comics.postValue(DataState.Success(comicsResponse))
    }

    fun onFaild(message: Throwable) {
        _Comics.postValue(message.localizedMessage?.let { DataState.Error(it) })
    }

    override fun onClickComics(comics: ComicModel) {
        _selectedComicsItem.postValue(Event(comics))
    }
}
