package com.example.marvel_hub.ui.details.series

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
import com.example.marvel_hub.ui.details.listeners.EventsListener
import com.example.marvel_hub.ui.details.listeners.StoryListener
import com.example.marvel_hub.ui.details.stories.StoriesDetailsEvents
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SeriesDetailsViewModel : BaseViewModel(), ComicListener, EventsListener, CharacterListener,
    StoryListener {

    private val _series =
        MutableLiveData<State<SeriesModel>>(State.Loading)
    val series: LiveData<State<SeriesModel>>
        get() = _series

    private val _character =
        MutableLiveData<State<CharactersModel>>(State.Loading)
    val character: LiveData<State<CharactersModel>>
        get() = _character

    private val _comics =
        MutableLiveData<State<ComicModel>>(State.Loading)
    val comics: LiveData<State<ComicModel>>
        get() = _comics

    private val _events =
        MutableLiveData<State<EventModel>>(State.Loading)
    val events: LiveData<State<EventModel>>
        get() = _events

    private val _stories =
        MutableLiveData<State<StoriesModel>>(State.Loading)
    val stories: LiveData<State<StoriesModel>>
        get() = _stories
    private val _seriesDetails: MutableLiveData<SeriesDetailsEvents> = MutableLiveData()
    val seriesDetails: LiveData<SeriesDetailsEvents>
        get() = _seriesDetails

    fun getSeriesById(SeriesId: Int) =
        repository.getSeriesById(SeriesId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::seriesOnSuccess, ::seriesOnError)
            .addTo(disposable)

    private fun seriesOnSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results))
    }

    private fun seriesOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }

    fun getComicsBySeriesId(seriesId: Int) =
        repository.getComicsBySeriesId(seriesId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::comicOnSuccess, ::comicsOnError)
            .addTo(disposable)

    private fun comicOnSuccess(comics: BaseResponse<ComicModel>) {
        _comics.postValue(State.Success(comics.data?.results))
    }

    private fun comicsOnError(error: Throwable) {
        _comics.postValue(State.Error(error.message.toString()))
    }

    fun getCharactersBySeriesId(seriesId: Int) =
        repository.getCharactersBySeriesId(seriesId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::characterOnSuccess, ::characterOnError)
            .addTo(disposable)

    private fun characterOnSuccess(character: BaseResponse<CharactersModel>) {
        _character.postValue(State.Success(character.data?.results))
    }

    private fun characterOnError(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    fun getEventsBySeriesId(seriesId: Int) =
        repository.getEventsByCharacterId(seriesId).observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::eventsOnSuccess, ::eventsOnError)
            .addTo(disposable)

    private fun eventsOnSuccess(events: BaseResponse<EventModel>) {
        _events.postValue(State.Success(events.data?.results))
    }

    private fun eventsOnError(error: Throwable) {
        _events.postValue(State.Error(error.message.toString()))
    }

    fun getStoriesBySeriesId(seriesId: Int) =
        repository.getStoriesBySeriesId(seriesId).observeOn(Schedulers.io())
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
        _seriesDetails.postValue(SeriesDetailsEvents.ClickCharacterSeries(character))

    }

    override fun onComicClick(comic: ComicModel) {
        _seriesDetails.postValue(SeriesDetailsEvents.ClickComicSeries(comic))

    }
    override fun onStoryClick(story: StoriesModel) {
        _seriesDetails.postValue(SeriesDetailsEvents.ClickStoriesSeries(story))
    }

    override fun onEventClick(event: EventModel) {
        _seriesDetails.postValue(SeriesDetailsEvents.ClickEventSeries(event))
    }
    fun clearEvents() {
        if (_seriesDetails.value != SeriesDetailsEvents.ReadyState)
            _seriesDetails.postValue(SeriesDetailsEvents.ReadyState)
    }
}