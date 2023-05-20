package com.example.marvel_hub.ui.details.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.ComicListener
import com.example.marvel_hub.ui.listeners.EventsListener
import com.example.marvel_hub.ui.listeners.SeriesListener
import com.example.marvel_hub.ui.listeners.StoryListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject
@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: IMarvelRepository,
): BaseViewModel(), ComicListener, EventsListener, SeriesListener,
    StoryListener {

    private val _character = MutableLiveData<State<CharactersModel>>(State.Loading)
    val character: LiveData<State<CharactersModel>>
        get() = _character

    private val _comics = MutableLiveData<State<ComicModel>>(State.Loading)
    val comics: LiveData<State<ComicModel>>
        get() = _comics

    private val _series = MutableLiveData<State<SeriesModel>>(State.Loading)
    val series: LiveData<State<SeriesModel>>
        get() = _series

    private val _events = MutableLiveData<State<EventModel>>(State.Loading)
    val events: LiveData<State<EventModel>>
        get() = _events
    private val _stories = MutableLiveData<State<StoriesModel>>(State.Loading)
    val stories: LiveData<State<StoriesModel>>
        get() = _stories
    private val _comicEvent = MutableLiveData<Event<ComicModel>>()
    val comicEvent: LiveData<Event<ComicModel>>
        get() = _comicEvent

    private val _eventEvent = MutableLiveData<Event<EventModel>>()
    val eventEvent: LiveData<Event<EventModel>>
        get() = _eventEvent

    private val _seriesEvent = MutableLiveData<Event<SeriesModel>>()
    val seriesEvent: LiveData<Event<SeriesModel>>
        get() = _seriesEvent

    private val _storyEvent = MutableLiveData<Event<StoriesModel>>()
    val storyEvent: LiveData<Event<StoriesModel>>
        get() = _storyEvent


    fun getAllDataById(id: Int) {
        getCharacterById(id)
        getSeriesByCharacterId(id)
        getEventsByCharacterId(id)
        getComicsByCharacterId(id)
        getStoriesByCharacterId(id)
    }


    private fun getCharacterById(characterId: Int) =
        repository.getCharacterById(characterId)
            .addSchedulers()
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(State.Success(character.data?.results))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }

    private fun getComicsByCharacterId(characterId: Int) =
        repository.getComicsByCharacterId(characterId)
            .addSchedulers()
            .subscribe(::comicOnSuccess, ::comicsOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(State.Success(comics.data?.results))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(State.Error(error.message.toString()))
    }

    private fun getSeriesByCharacterId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId)
            .addSchedulers()
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    private fun getEventsByCharacterId(characterId: Int) =
        repository.getEventsByCharacterId(characterId)
            .addSchedulers()
            .subscribe(::eventsOnSuccess, ::eventsOnError)
            .addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(State.Success(events.data?.results))
    }

    private fun eventsOnError(error: Throwable) {
        _events.postValue(State.Error(error.message.toString()))
    }

    private fun getStoriesByCharacterId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId)
            .addSchedulers()
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(stories: BaseResponse<StoriesModel>) {
        _stories.postValue(State.Success(stories.data?.results))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(State.Error(error.message.toString()))
    }

    override fun onComicClick(comic: ComicModel) {
        _comicEvent.postValue(Event(comic))
    }

    override fun onEventClick(event: EventModel) {
        _eventEvent.postValue(Event(event))
    }

    override fun onSeriesClick(series: SeriesModel) {
        _seriesEvent.postValue(Event(series))
    }

    override fun onStoryClick(story: StoriesModel) {
        _storyEvent.postValue(Event(story))
    }

}