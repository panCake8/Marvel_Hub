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

    fun getEventById(eventId: Int) =
        repository.getEventsById(eventId)
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
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
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
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
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
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
            .observeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(::storiesOnSuccess, ::storiesOnError)
            .addTo(disposable)

    private fun storiesOnSuccess(stories: BaseResponse<StoriesModel>) {
        _stories.postValue(State.Success(stories.data?.results))
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
        _character.postValue(State.Success(character.data?.results))
    }

    private fun characterOnError(error: Throwable) {
        _character.postValue(State.Error(error.message.toString()))
    }


    override fun onCharacterClick(character: CharactersModel) {

    }

    override fun onComicClick(comic: ComicModel) {

    }

    override fun onSeriesClick(series: SeriesModel) {

    }

    override fun onStoryClick(story: StoriesModel) {

    }

}