package com.example.marvel_hub.ui.details.events

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
import com.example.marvel_hub.ui.listeners.SeriesListener
import com.example.marvel_hub.ui.listeners.StoryListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class EventsDetailsViewModel : BaseViewModel(),
    ComicListener,
    CharacterListener,
    SeriesListener,
    StoryListener {

    private val _events =
        MutableLiveData<State<EventModel>>(State.Loading)

    val events: LiveData<State<EventModel>>
        get() = _events

    private val _character =
        MutableLiveData<State<CharactersModel>>(State.Loading)

    val character: LiveData<State<CharactersModel>>
        get() = _character

    private val _comics =
        MutableLiveData<State<ComicModel>>(State.Loading)

    val comics: LiveData<State<ComicModel>>
        get() = _comics

    private val _series =
        MutableLiveData<State<SeriesModel>>(State.Loading)

    val series: LiveData<State<SeriesModel>>
        get() = _series

    private val _stories =
        MutableLiveData<State<StoriesModel>>(State.Loading)

    val stories: LiveData<State<StoriesModel>>
        get() = _stories

    private val _comicEvent = MutableLiveData<Event<ComicModel>>()
    val comicEvent: LiveData<Event<ComicModel>>
        get() = _comicEvent

    private val _characterEvent = MutableLiveData<Event<CharactersModel>>()
    val characterEvent: LiveData<Event<CharactersModel>>
        get() = _characterEvent

    private val _storiesEvent = MutableLiveData<Event<StoriesModel>>()
    val storiesEvent: LiveData<Event<StoriesModel>>
        get() = _storiesEvent
    private val _seriesEvent = MutableLiveData<Event<SeriesModel>>()
    val seriesEvent: LiveData<Event<SeriesModel>>
        get() = _seriesEvent


    fun getAllDataById(id: Int) {
        getEventById(id)
        getCharacterByEventId(id)
        getComicsByEventId(id)
        getSeriesByEventId(id)
        getStoriesByEventId(id)
    }

    private fun getEventById(eventId: Int) =
        repository.getEventsById(eventId)
            .applySchedulers()
            .subscribe(::eventOnSuccess, ::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(event: BaseResponse<EventModel>) {
        _events.postValue(State.Success(event.data?.results))
    }

    private fun eventOnError(error: Throwable) {
        _events.postValue(State.Error(error.message.toString()))
    }

    private fun getComicsByEventId(characterId: Int) =
        repository.getComicsByCharacterId(characterId)
            .applySchedulers()
            .subscribe(::comicOnSuccess, ::comicsOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(State.Success(comics.data?.results))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(State.Error(error.message.toString()))
    }

    private fun getSeriesByEventId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId)
            .applySchedulers()
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    private fun getStoriesByEventId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId)
            .applySchedulers()
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(stories: BaseResponse<StoriesModel>) {
        _stories.postValue(State.Success(stories.data?.results))
    }

    fun storiesOnError(error: Throwable) {
        _stories.postValue(State.Error(error.message.toString()))
    }

    private fun getCharacterByEventId(characterId: Int) =
        repository.getCharacterById(characterId)
            .applySchedulers()
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(State.Success(character.data?.results))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }


    override fun onCharacterClick(character: CharactersModel) {
        _characterEvent.postValue(Event(character))
    }

    override fun onComicClick(comic: ComicModel) {
        _comicEvent.postValue((Event(comic)))
    }

    override fun onStoryClick(story: StoriesModel) {
        _storiesEvent.postValue(Event(story))
    }

    override fun onSeriesClick(series: SeriesModel) {
        _seriesEvent.postValue(Event(series))
    }

}