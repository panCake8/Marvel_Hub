package com.example.marvel_hub.ui.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.util.State
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.ComicListener
import com.example.marvel_hub.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject
@HiltViewModel
class ComicViewModel @Inject constructor(
    private val repository: IMarvelRepository,
): BaseViewModel(), ComicListener {

    private val _comic = MutableLiveData<State<ComicModel>>(State.Loading)
    val comic: LiveData<State<ComicModel>>
        get() = _comic

    private val _selectedComicItem = MutableLiveData<Event<Int?>>()
    val selectedComicItem: LiveData<Event<Int?>>
        get() = _selectedComicItem

    init {
        getComics()
    }

    private fun getComics() {
        repository.getAllComics()
            .addSchedulers()
            .subscribe(::onSuccess, ::onFailed)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(comicsResponse: BaseResponse<ComicModel>) {
        _comic.postValue(State.Success(comicsResponse.data?.results!!))
    }

    private fun onFailed(error: Throwable) {
        _comic.postValue(State.Error(error.message.toString()))
    }

    override fun onComicClick(comic: ComicModel) {
        _selectedComicItem.postValue(Event(comic.id))
    }


}
