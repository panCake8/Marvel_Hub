package com.example.marvel_hub.ui.details.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.List
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

class StoriesDetailsViewModel : BaseViewModel() {

    private val _story =
        MutableLiveData<DataState<StoriesModel>>()

    val story: LiveData<DataState<StoriesModel>>
        get() = _story


    private val _characters =
        MutableLiveData<DataState<kotlin.collections.List<CharactersModel>?>>(DataState.Loading)
    val characters: LiveData<DataState<kotlin.collections.List<CharactersModel>?>>
        get() = _characters


    private val _comics =
        MutableLiveData<DataState<kotlin.collections.List<ComicModel>?>>(DataState.Loading)
    val comics: LiveData<DataState<kotlin.collections.List<ComicModel>?>>
        get() = _comics


    private val _series =
        MutableLiveData<DataState<kotlin.collections.List<SeriesModel>?>>(DataState.Loading)
    val series: LiveData<DataState<kotlin.collections.List<SeriesModel>?>>
        get() = _series


    private val _events =
        MutableLiveData<DataState<kotlin.collections.List<EventModel>?>>(DataState.Loading)
    val events: LiveData<DataState<kotlin.collections.List<EventModel>?>>
        get() = _events


    fun getStoryById(storyId: Int) =
        repository.getStoryById(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::storyOnSuccess,
                ::storyOnError
            ).addTo(disposable)

    private fun storyOnSuccess(story: List<StoriesModel>) {
        _story.postValue(story.data?.results?.get(0).let { DataState.Success(it!!) })
    }
    private fun storyOnError(error: Throwable) {
        _story.postValue(error.message.toString().let { DataState.Error(it) })
    }


    fun getCharactersByStoryId(storyId: Int) =
        repository.getCharactersByStoryId(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::charactersOnSuccess,
                this::charactersOnError
            ).addTo(disposable)

    private fun charactersOnSuccess(characters: List<CharactersModel>) {
        _characters.postValue(characters.data?.results.let { DataState.Success(it) })
    }
    private fun charactersOnError(error: Throwable) {
        _characters.postValue(error.message.toString().let { DataState.Error(it) })
    }


    fun getComicsByStoryId(storyId: Int) =
        repository.getComicsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::comicOnSuccess, this::comicOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: List<ComicModel>) {
        _comics.postValue(comics.data?.results.let { DataState.Success(it) })
    }
    private fun comicOnError(error: Throwable) {
        _comics.postValue(error.message.toString().let { DataState.Error(it) })
    }


    fun getSeriesByStoryId(storyId: Int) =
        repository.getSeriesByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::seriesOnSuccess, this::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: List<SeriesModel>) {
        _series.postValue(series.data?.results.let { DataState.Success(it) })
    }
    private fun seriesOnError(error: Throwable) {
        _series.postValue(error.message.toString().let { DataState.Error(it) })
    }


    fun getEventsByStoryId(storyId: Int) =
        repository.getEventsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::eventOnSuccess, this::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(events: List<EventModel>) {
        _events.postValue(events.data?.results.let { DataState.Success(it) })
    }
    private fun eventOnError(error: Throwable) {
        _events.postValue(error.message.toString().let { DataState.Error(it) })
    }


}