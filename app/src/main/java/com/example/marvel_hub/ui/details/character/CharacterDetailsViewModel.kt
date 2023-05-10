package com.example.marvel_hub.ui.details.character

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsViewModel : BaseViewModel() {

    private val _character = MutableLiveData<CharactersModel>()
    val character: LiveData<CharactersModel>
        get() = _character

    private val _comics = MutableLiveData<BaseResponse<ComicModel>>()
    val comics: LiveData<BaseResponse<ComicModel>>
        get() = _comics

    private val _series = MutableLiveData<BaseResponse<SeriesModel>>()
    val series: LiveData<BaseResponse<SeriesModel>>
        get() = _series

    private val _events = MutableLiveData<BaseResponse<EventModel>>()
    val events: LiveData<BaseResponse<EventModel>>
        get() = _events

    private val _stories = MutableLiveData<BaseResponse<StoriesModel>>()
    val stories: LiveData<BaseResponse<StoriesModel>>
        get() = _stories

    fun getCharacterById(characterId: Int) =
        repository.getCharacterById(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError).addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(character.data?.results?.get(FIRST_ITEM))
    }

    private fun characterOnError(error: Throwable) {
        //  _character.postValue(DataState.Error())
        Log.e("ahmed", error.message.toString())
    }

    private fun getComicsByCharacterId(characterId: Int) =
        repository.getComicsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicsOnError).addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        //    _comics.postValue(DataState.Success(comics))
    }

    private fun comicsOnError(error: Throwable) {
        // _comics.postValue(DataState.Error(error.message.toString()))
    }

    private fun getSeriesByCharacterId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError).addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        // _series.postValue(DataState.Success(series))
    }

    private fun seriesOnError(error: Throwable) {
        // _series.postValue(DataState.Error(error.message.toString()))
    }

    private fun getEventsByCharacterId(characterId: Int) =
        repository.getEventsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventsOnSuccess, ::eventsOnError).addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        //  _events.postValue(DataState.Success(events))
    }

    private fun eventsOnError(error: Throwable) {
        // _events.postValue(DataState.Error(error.message.toString()))
    }

    fun getStoriesByCharacterId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError).addTo(disposable)

    private fun storiesOnSuccess(events: BaseResponse<StoriesModel>) {
        Log.e("ahmed", events.data?.results.toString())
        // _stories.postValue(DataState.Success(events))
    }

    private fun storiesOnError(error: Throwable) {
        Log.e("ahmed", error.message.toString())
        // _stories.postValue(DataState.Error(error.message.toString()))
    }

    companion object {
        const val FIRST_ITEM = 0
    }
}