package com.example.marvel_hub.ui.details.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.util.State
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.details.listeners.CharacterListener
import com.example.marvel_hub.ui.details.listeners.EventsListener
import com.example.marvel_hub.ui.details.listeners.SeriesListener
import com.example.marvel_hub.ui.details.listeners.StoryListener
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class ComicsDetailsViewModel
    : BaseViewModel(), EventsListener, SeriesListener, StoryListener, CharacterListener {
    private val _comics =
        MutableLiveData<State<ComicModel>>(State.Loading)
    val comics: LiveData<State<ComicModel>>
        get() = _comics

    private val _character =
        MutableLiveData<State<CharactersModel>>(State.Loading)
    val character: LiveData<State<CharactersModel>>
        get() = _character

    private val _series =
        MutableLiveData<State<SeriesModel>>(State.Loading)
    val series: LiveData<State<SeriesModel>>
        get() = _series

    private val _events =
        MutableLiveData<State<EventModel>>(State.Loading)
    val events: LiveData<State<EventModel>>
        get() = _events

    private val _stories =
        MutableLiveData<State<StoriesModel>>(State.Loading)
    val stories: LiveData<State<StoriesModel>>
        get() = _stories

    private val _comicDetails: MutableLiveData<ComicsDetailsEvents> = MutableLiveData()
    val comicDetails: LiveData<ComicsDetailsEvents>
        get() = _comicDetails

    private val _storiesEvent = MutableLiveData<Event<StoriesModel>>()
    val storiesEvent: LiveData<Event<StoriesModel>>
        get() = _storiesEvent

    private val _characterEvent = MutableLiveData<Event<CharactersModel>>()
    val characterEvent: LiveData<Event<CharactersModel>>
        get() = _characterEvent

    private val _eventEvent = MutableLiveData<Event<EventModel>>()
    val eventEvent: LiveData<Event<EventModel>>
        get() = _eventEvent

    private val _seriesEvent = MutableLiveData<Event<SeriesModel>>()
    val seriesEvent : LiveData<Event<SeriesModel>>
        get() = _seriesEvent

    fun getComicById(comicId: Int) =
        repository.getComicById(comicId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comic: BaseResponse<ComicModel>) {
        _comics.postValue(State.Success(comic.data?.results))
    }

    private fun comicOnError(error: Throwable) {
        _comics.postValue(State.Error(error.message.toString()))
    }

    private fun getCharacterByComicId(comicId: Int) =
        repository.getCharactersByComicId(comicId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(State.Success(character.data?.results))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }

    private fun getSeriesByComicId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    private fun getEventsByByComicId(characterId: Int) =
        repository.getEventsByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventsOnSuccess, ::eventsOnError)
            .addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(State.Success(events.data?.results))
    }

    private fun eventsOnError(error: Throwable) {
        _events.postValue(State.Error(error.message.toString()))
    }

    private fun getStoriesByComicById(characterId: Int) =
        repository.getStoriesByCharacterId(characterId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(events: BaseResponse<StoriesModel>) {
        _stories.postValue(State.Success(events.data?.results))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(State.Error(error.message.toString()))
    }

    override fun onCharacterClick(character: CharactersModel) {
        _characterEvent.postValue(Event(character))

    }

    override fun onEventClick(event: EventModel) {
        _eventEvent.postValue(Event(event))
    }

    override fun onSeriesClick(series: SeriesModel) {
        _seriesEvent.postValue(Event(series))
    }

    override fun onStoryClick(story: StoriesModel) {
        _storiesEvent.postValue(Event(story))
    }
    fun clearEvents() {
        if (_comicDetails.value != ComicsDetailsEvents.ReadyState)
            _comicDetails.postValue(ComicsDetailsEvents.ReadyState)
    }
}