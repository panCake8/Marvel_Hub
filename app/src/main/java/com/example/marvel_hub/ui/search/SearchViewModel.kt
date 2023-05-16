package com.example.marvel_hub.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.CharacterListener
import com.example.marvel_hub.ui.listeners.ComicListener
import com.example.marvel_hub.ui.listeners.EventsListener
import com.example.marvel_hub.ui.listeners.SeriesListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.kotlin.addTo

class SearchViewModel : BaseViewModel(), EventsListener,
    ComicListener,
    SeriesListener, CharacterListener {

    private val _searchStatus =
        MutableLiveData(SearchStatus.COMIC)
    val searchStatus: LiveData<SearchStatus>
        get() = _searchStatus

    private val _searchList = MutableLiveData<State<Any>>(State.Loading)
    val searchList: LiveData<State<Any>>
        get() = _searchList

     val searchText = MutableLiveData<String>()

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


    fun getDataBySearchText() {
        when (searchStatus.value) {
            SearchStatus.CHARACTER -> searchText.value?.let { getCharacterData(it) }
            SearchStatus.COMIC -> searchText.value?.let { getComicData(it) }
            SearchStatus.SERIES -> searchText.value?.let { getSeriesData(it) }
            else -> searchText.value?.let { getEventData(it) }
        }
    }

  private  fun getComicData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchComics(text)
            .applySchedulers()
            .subscribe(::onGetComicsSuccess, ::onGetComicsError)
            .addTo(disposable)
    }

    private fun onGetComicsSuccess(comics: BaseResponse<ComicModel>) {
        _searchList.postValue(State.Success(comics.data?.results ?: listOf()))
    }

    private fun onGetComicsError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }

    private  fun getSeriesData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchSeries(text)
            .applySchedulers()
            .subscribe(::onGetSeriesSuccess, ::onGetSeriesError)
            .addTo(disposable)
    }

    private fun onGetSeriesSuccess(series: BaseResponse<SeriesModel>) {
        _searchList.postValue(State.Success(series.data?.results ?: listOf()))
    }

    private fun onGetSeriesError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }


    private  fun getEventData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchEvents(text)
            .applySchedulers()
            .subscribe(::onGetEventSuccess, ::onGetEventError)
            .addTo(disposable)
    }

    private fun onGetEventSuccess(events: BaseResponse<EventModel>) {
        _searchList.postValue(State.Success(events.data?.results ?: listOf()))
    }


    private fun onGetEventError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }

    private    fun getCharacterData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchCharacters(text)
            .applySchedulers()
            .subscribe(::onGetCharacterSuccess, ::onGetCharacterError)
            .addTo(disposable)
    }

    private fun onGetCharacterSuccess(character: BaseResponse<CharactersModel>) {
        _searchList.postValue(State.Success(character.data?.results ?: listOf()))
    }


    private fun onGetCharacterError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))

    }

    fun onClickComicChip() {
        _searchStatus.postValue(SearchStatus.COMIC)
        searchText.value?.let { getComicData(it) }
    }

    fun onClickEventChip() {
        _searchStatus.postValue(SearchStatus.EVENT)
        searchText.value?.let { getEventData(it) }
    }

    fun onClickSeriesChip() {
        _searchStatus.postValue(SearchStatus.SERIES)
        searchText.value?.let { getSeriesData(it) }
    }

    fun onClickCharacterChip() {
        _searchStatus.postValue(SearchStatus.CHARACTER)
        searchText.value?.let { getCharacterData(it) }
    }

    override fun onCharacterClick(character: CharactersModel) {
        _characterEvent.postValue(Event(character))
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

}

