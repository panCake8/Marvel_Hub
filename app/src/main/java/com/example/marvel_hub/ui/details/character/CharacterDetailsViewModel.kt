package com.example.marvel_hub.ui.details.character

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
import com.example.marvel_hub.ui.details.listeners.ComicListener
import com.example.marvel_hub.ui.details.listeners.EventsListener
import com.example.marvel_hub.ui.details.listeners.SeriesListener
import com.example.marvel_hub.ui.details.listeners.StoryListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterDetailsViewModel : BaseViewModel(), ComicListener,EventsListener,SeriesListener,StoryListener {

    private val _character = MutableLiveData<DataState<CharactersModel>>(DataState.Loading)
    val character: LiveData<DataState<CharactersModel>>
        get() = _character

    private val _comics = MutableLiveData<DataState<List<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<List<ComicModel>>>
        get() = _comics

    private val _series = MutableLiveData<DataState<List<SeriesModel>>>(DataState.Loading)
    val series: LiveData<DataState<List<SeriesModel>>>
        get() = _series

    private val _events = MutableLiveData<DataState<List<EventModel>>>(DataState.Loading)
    val events: LiveData<DataState<List<EventModel>>>
        get() = _events

    private val _stories = MutableLiveData<DataState<List<StoriesModel>>>(DataState.Loading)
    val stories: LiveData<DataState<List<StoriesModel>>>
        get() = _stories

    fun getCharacterById(characterId: Int) =
        repository.getCharacterById(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError).addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(DataState.Success(character.data?.results?.get(FIRST_ITEM)!!))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(DataState.Error(error.message.toString()))
    }

     fun getComicsByCharacterId(characterId: Int) =
        repository.getComicsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicsOnError).addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(DataState.Success(comics.data?.results ?: listOf()))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(DataState.Error(error.message.toString()))
    }

     fun getSeriesByCharacterId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError).addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(DataState.Success(series.data?.results ?: listOf()))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(DataState.Error(error.message.toString()))
    }

     fun getEventsByCharacterId(characterId: Int) =
        repository.getEventsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventsOnSuccess, ::eventsOnError).addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(DataState.Success(events.data?.results ?: listOf()))
    }

    private fun eventsOnError(error: Throwable) {
        _events.postValue(DataState.Error(error.message.toString()))
    }

    fun getStoriesByCharacterId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError).addTo(disposable)

    private fun storiesOnSuccess(stories: BaseResponse<StoriesModel>) {
        _stories.postValue(DataState.Success(stories.data?.results ?: listOf()))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(DataState.Error(error.message.toString()))
    }

    companion object {
        const val FIRST_ITEM = 0
    }

    override fun onComicClick(comic: ComicModel) {

    }

    override fun onEventClick(event: EventModel) {

    }

    override fun onSeriesClick(series: SeriesModel) {

    }

    override fun onStoryClick(story: StoriesModel) {

    }
}