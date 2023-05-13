package com.example.marvel_hub.ui.details.events

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
import com.example.marvel_hub.ui.details.listeners.ComicListener
import com.example.marvel_hub.ui.details.listeners.SeriesListener
import com.example.marvel_hub.ui.details.listeners.StoryListener
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
        MutableLiveData<State<List<CharactersModel>>>(State.Loading)

    val character: LiveData<State<List<CharactersModel>>>
        get() = _character

    private val _comics =
        MutableLiveData<State<List<ComicModel>>>(State.Loading)

    val comics: LiveData<State<List<ComicModel>>>
        get() = _comics

    private val _series =
        MutableLiveData<State<List<SeriesModel>>>(State.Loading)

    val series: LiveData<State<List<SeriesModel>>>
        get() = _series

    private val _stories =
        MutableLiveData<State<List<StoriesModel>>>(State.Loading)

    val stories: LiveData<State<List<StoriesModel>>>
        get() = _stories
    private val _eventDetails: MutableLiveData<EventsDetailsEvents> = MutableLiveData()
        val eventDetails: LiveData<EventsDetailsEvents>
        get() = _eventDetails

    fun getEventById(eventId: Int) =
        repository.getEventsById(eventId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventOnSuccess, ::eventOnError)
            .addTo(disposable)

    private fun eventOnSuccess(event: BaseResponse<EventModel>) {
        _events.postValue(State.Success(event.data?.results?.get(FIRST_ITEM)!!))
    }

    private fun eventOnError(error: Throwable) {
        _events.postValue(State.Error(error.message.toString()))
    }

    private fun getComicsByEventId(characterId: Int) =
        repository.getComicsByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicsOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(State.Success(comics.data?.results ?: listOf()))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(State.Error(error.message.toString()))
    }

    private fun getSeriesByEventId(characterId: Int) =
        repository.getSeriesByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results ?: listOf()))
    }

    private fun seriesOnError(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    private fun getStoriesByEventId(characterId: Int) =
        repository.getStoriesByCharacterId(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(stories: BaseResponse<StoriesModel>) {
        _stories.postValue(State.Success(stories.data?.results ?: listOf()))
    }

    private fun storiesOnError(error: Throwable) {
        _stories.postValue(State.Error(error.message.toString()))
    }

    private fun getCharacterByEventId(characterId: Int) =
        repository.getCharacterById(characterId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(State.Success(character.data?.results ?: listOf()))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }

    companion object {
        const val FIRST_ITEM = 0
    }

    override fun onCharacterClick(character: CharactersModel) {
        _eventDetails.postValue(EventsDetailsEvents.ClickCharacterEvent(character))

    }

    override fun onComicClick(comic: ComicModel) {
        _eventDetails.postValue(EventsDetailsEvents.ClickComicEvent(comic))

    }
    override fun onSeriesClick(series: SeriesModel) {
        _eventDetails.postValue(EventsDetailsEvents.ClickSeriesEvent(series))
    }

    override fun onStoryClick(story: StoriesModel) {
        _eventDetails.postValue(EventsDetailsEvents.ClickStoriesEvent(story))
    }
    fun clearEvents() {
        if (_eventDetails.value != EventsDetailsEvents.ReadyState)
            _eventDetails.postValue(EventsDetailsEvents.ReadyState)
    }

}