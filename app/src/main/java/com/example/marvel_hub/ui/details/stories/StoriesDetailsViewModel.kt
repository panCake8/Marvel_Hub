package com.example.marvel_hub.ui.details.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.CharacterListener
import com.example.marvel_hub.ui.listeners.ComicListener
import com.example.marvel_hub.ui.listeners.EventsListener
import com.example.marvel_hub.ui.listeners.SeriesListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class StoriesDetailsViewModel : BaseViewModel(), EventsListener, CharacterListener, ComicListener,
    SeriesListener {

    private val _story =
        MutableLiveData<State<StoriesModel>>()

    val story: LiveData<State<StoriesModel>>
        get() = _story


    private val _characters =
        MutableLiveData<State<CharactersModel>>(State.Loading)
    val characters: LiveData<State<CharactersModel>>
        get() = _characters


    private val _comics =
        MutableLiveData<State<ComicModel>>(State.Loading)
    val comics: LiveData<State<ComicModel>>
        get() = _comics


    private val _series =
        MutableLiveData<State<SeriesModel>>(State.Loading)
    val series: LiveData<State<SeriesModel>>
        get() = _series


    private val _events =
        MutableLiveData<State<EventModel>>(State.Loading)
    val events: LiveData<State<EventModel>>
        get() = _events

    private val _comicEvent = MutableLiveData<Event<ComicModel>>()
    val comicEvent: LiveData<Event<ComicModel>>
        get() = _comicEvent

    private val _characterEvent = MutableLiveData<Event<CharactersModel>>()
    val characterEvent: LiveData<Event<CharactersModel>>
        get() = _characterEvent

    private val _eventEvent = MutableLiveData<Event<EventModel>>()
    val eventEvent: LiveData<Event<EventModel>>
        get() = _eventEvent

    private val _seriesEvent = MutableLiveData<Event<SeriesModel>>()
    val seriesEvent: LiveData<Event<SeriesModel>>
        get() = _seriesEvent


    fun getAllDataById(id: Int) {
        getStoryById(id)
        getCharactersByStoryId(id)
        getComicsByStoryId(id)
        getCharactersByStoryId(id)
        getStoryById(id)
    }

    private fun getStoryById(storyId: Int) =
        repository.getStoryById(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::storyOnSuccess,
                ::storyOnError
            ).addTo(disposable)

    private fun storyOnSuccess(story: BaseResponse<StoriesModel>) {
        _story.postValue(State.Success(story.data?.results))
    }

    private fun storyOnError(error: Throwable) {
        _story.postValue(error.message.toString().let { State.Error(it) })
    }


    private fun getCharactersByStoryId(storyId: Int) =
        repository.getCharactersByStoryId(storyId).observeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                ::charactersOnSuccess,
                ::charactersOnError
            ).addTo(disposable)

    private fun charactersOnSuccess(characters: BaseResponse<CharactersModel>) {
        _characters.postValue(characters.data?.results.let { State.Success(it) })
    }

    private fun charactersOnError(error: Throwable) {
        _characters.postValue(error.message.toString().let { State.Error(it) })
    }


    private fun getComicsByStoryId(storyId: Int) =
        repository.getComicsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::comicOnSuccess, this::comicOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(comics.data?.results.let { State.Success(it) })
    }

    private fun comicOnError(error: Throwable) {
        _comics.postValue(error.message.toString().let { State.Error(it) })
    }


    private fun getSeriesByStoryId(storyId: Int) =
        repository.getSeriesByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::seriesOnSuccess, this::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(series.data?.results.let { State.Success(it) })
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(error.message.toString().let { State.Error(it) })
    }


    private fun getEventsByStoryId(storyId: Int) =
        repository.getEventsByStoryId(storyId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(this::eventOnSuccess, this::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(events.data?.results.let { State.Success(it) })
    }

    private fun eventOnError(error: Throwable) {
        _events.postValue(error.message.toString().let { State.Error(it) })
    }

    override fun onCharacterClick(character: CharactersModel) {
        _characterEvent.postValue(Event(character))
    }

    override fun onComicClick(comic: ComicModel) {
        _comicEvent.postValue(Event(comic))
    }

    override fun onSeriesClick(series: SeriesModel) {
        _seriesEvent.postValue(Event(series))
    }

    override fun onEventClick(event: EventModel) {
        _eventEvent.postValue(Event(event))
    }

}