package com.example.marvel_hub.ui.details.stories

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

class StoriesDetailsViewModel : BaseViewModel() {

    private val _stories =
        MutableLiveData<DataState<BaseResponse<StoriesModel>>>()

    val stories: LiveData<DataState<BaseResponse<StoriesModel>>>
        get() = _stories


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


    private val _events =
        MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)
    val events: LiveData<DataState<BaseResponse<EventModel>>>
        get() = _events


    fun getStoryById(storyId: Int) =
        repository.getStoryById(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::storyOnSuccess,
                ::storyOnError
            ).addTo(disposable)

    private fun storyOnSuccess(response: BaseResponse<StoriesModel>) {}
    private fun storyOnError(error: Throwable) {}


    fun getCharactersByStoryId(storyId: Int) =
        repository.getCharactersByStoryId(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::charactersOnSuccess,
                this::charactersOnError
            ).addTo(disposable)

    private fun charactersOnSuccess(response: BaseResponse<CharactersModel>) {}
    private fun charactersOnError(error: Throwable) {}


    fun getComicsByStoryId(storyId: Int) =
        repository.getComicsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::comicOnSuccess, this::comicOnError)
            .addTo(disposable)

    private fun comicOnSuccess(response: BaseResponse<ComicModel>) {}
    private fun comicOnError(error: Throwable) {}


    fun getSeriesByStoryId(storyId: Int) =
        repository.getSeriesByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::seriesOnSuccess, this::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(response: BaseResponse<SeriesModel>) {}
    private fun seriesOnError(error: Throwable) {}


    fun getEventsByStoryId(storyId: Int) =
        repository.getEventsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::eventOnSuccess, this::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(response: BaseResponse<EventModel>) {}
    private fun eventOnError(error: Throwable) {}


}