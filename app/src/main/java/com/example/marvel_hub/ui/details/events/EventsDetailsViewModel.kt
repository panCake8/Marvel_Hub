package com.example.marvel_hub.ui.details.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class EventsDetailsViewModel : BaseViewModel() {

    private val _events =
        MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)

    val events: LiveData<DataState<BaseResponse<EventModel>>>
        get() = _events

    private val _character =
        MutableLiveData<DataState<BaseResponse<CharactersModel>>>(DataState.Loading)

    val character: LiveData<DataState<BaseResponse<CharactersModel>>>
        get() = _character

    private val _comics =
        MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)

    val comics: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _comics

    private val _series =
        MutableLiveData<DataState<BaseResponse<SeriesModel>>>(DataState.Loading)

    val series: LiveData<DataState<BaseResponse<SeriesModel>>>
        get() = _series

    private val _stories =
        MutableLiveData<DataState<BaseResponse<StoriesModel>>>(DataState.Loading)

    val stories: LiveData<DataState<BaseResponse<StoriesModel>>>
        get() = _stories

    fun getEventById(eventId: Int) =
        repository.getEventsById(eventId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventOnSuccess, ::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(event: BaseResponse<EventModel>) {
        _events.postValue(DataState.Success(event))
        val eventId = event.data?.results?.get(FIRST_ITEM)?.id!!
        getComicsByEventId(eventId)
        getCharacterByEventId(eventId)
        getSeriesByEventId(eventId)
        getStoriesByEventId(eventId)

    }

    private fun eventOnError(error: Throwable) {
        _events.postValue(DataState.Error(error.message.toString()))
    }

    private fun getComicsByEventId(characterId: Int) =
        repository.getComicsByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicsOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(DataState.Success(comics))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(DataState.Error(error.message.toString()))
    }

    private fun getSeriesByEventId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(DataState.Success(series))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(DataState.Error(error.message.toString()))
    }

    private fun getStoriesByEventId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(events: BaseResponse<StoriesModel>) {
        _stories.postValue(DataState.Success(events))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(DataState.Error(error.message.toString()))
    }

    fun getCharacterByEventId(characterId: Int) =
        repository.getCharacterById(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(DataState.Success(character))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(DataState.Error(error.message.toString()))
    }

    companion object {
        const val FIRST_ITEM = 0
    }
}