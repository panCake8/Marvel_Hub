package com.example.marvel_hub.ui.details.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ComicsDetailsViewModel: BaseViewModel() {
    private val _comics =
        MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _comics

    private val _character =
        MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val character: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _character

    private val _series =
        MutableLiveData<DataState<BaseResponse<SeriesModel>>>(DataState.Loading)
    val series: LiveData<DataState<BaseResponse<SeriesModel>>>
        get() = _series

    private val _events =
        MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)
    val events: LiveData<DataState<BaseResponse<EventModel>>>
        get() = _events

    private val _stories =
        MutableLiveData<DataState<BaseResponse<StoriesModel>>>(DataState.Loading)
    val stories: LiveData<DataState<BaseResponse<StoriesModel>>>
        get() = _stories

    fun getComicById(comicId: Int) =
        repository.getComicById(comicId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicOnError).addTo(disposable)

    private fun comicOnSuccess(comic: BaseResponse<ComicModel>) {
        _character.postValue(DataState.Success(comic))
        val comicId = comic.data?.results?.get(FIRST_ITEM)?.id!!
        getCharacterByComicId(comicId)
        getSeriesByComicId(comicId)
        getEventsByByComicId(comicId)
        getStoriesByComicById(comicId)
    }

    private fun comicOnError(error: Throwable) {
        _character.postValue(DataState.Error(error.message.toString()))
    }

    private fun getCharacterByComicId(comicId: Int) =
        repository.getComicsByCharacterId(comicId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError).addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<ComicModel>) {
        _character.postValue(DataState.Success(character))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(DataState.Error(error.message.toString()))
    }

    private fun getSeriesByComicId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError).addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(DataState.Success(series))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(DataState.Error(error.message.toString()))
    }

    private fun getEventsByByComicId(characterId: Int) =
        repository.getEventsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventsOnSuccess, ::eventsOnError).addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(DataState.Success(events))
    }

    private fun eventsOnError(error: Throwable) {
        _events.postValue(DataState.Error(error.message.toString()))
    }

    private fun getStoriesByComicById(characterId: Int) =
        repository.getStoriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError).addTo(disposable)

    private fun storiesOnSuccess(events: BaseResponse<StoriesModel>) {
        _stories.postValue(DataState.Success(events))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(DataState.Error(error.message.toString()))
    }

    companion object {
        const val FIRST_ITEM = 0
    }
}