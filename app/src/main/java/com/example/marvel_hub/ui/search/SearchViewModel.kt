package com.example.marvel_hub.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.local.entities.CharacterEntity
import com.example.marvel_hub.data.local.entities.ComicEntity
import com.example.marvel_hub.data.local.entities.EventEntity
import com.example.marvel_hub.data.local.entities.SeriesEntity
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.search.listener.CharacterSearchListener
import com.example.marvel_hub.ui.search.listener.ComicSearchListener
import com.example.marvel_hub.ui.search.listener.EventsSearchListener
import com.example.marvel_hub.ui.search.listener.SeriesSearchListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: IMarvelRepository,
) : BaseViewModel(), EventsSearchListener,
    ComicSearchListener,
    SeriesSearchListener, CharacterSearchListener {

    private val _searchStatus =
        MutableLiveData(SearchStatus.COMIC)
    val searchStatus: LiveData<SearchStatus>
        get() = _searchStatus

    private val _searchList = MutableLiveData<State<Any>>(State.Loading)
    val searchList: LiveData<State<Any>>
        get() = _searchList

    val searchText = MutableLiveData<String>()

    private val _comicEvent = MutableLiveData<Event<ComicEntity>>()
    val comicEvent: LiveData<Event<ComicEntity>>
        get() = _comicEvent

    private val _characterEvent = MutableLiveData<Event<CharacterEntity>>()
    val characterEvent: LiveData<Event<CharacterEntity>>
        get() = _characterEvent

    private val _eventEvent = MutableLiveData<Event<EventEntity>>()
    val eventEvent: LiveData<Event<EventEntity>>
        get() = _eventEvent

    private val _seriesEvent = MutableLiveData<Event<SeriesEntity>>()
    val seriesEvent: LiveData<Event<SeriesEntity>>
        get() = _seriesEvent


    fun getDataBySearchText() {
        when (searchStatus.value) {
            SearchStatus.CHARACTER -> {
                saveSearchKeyword("character")
                getCharacterData()
            }

            SearchStatus.COMIC -> {
                saveSearchKeyword("comics")
                getComicData()
            }

            SearchStatus.SERIES -> searchText.value?.let { getSeriesData(it) }
            else -> searchText.value?.let { getEventData(it) }
        }
    }

    private fun saveSearchKeyword(type: String) {
        searchText.value?.let {
            repository.saveSearchKeyword(it, type).subscribeOn(Schedulers.io())
        }
    }

    private fun getComicData() {
        _searchList.postValue(State.Loading)
        searchText.value?.let {
            val results = repository.getLocalSearchComics(it, "comics")
            Log.e("ahmed", results.toString())
            _searchList.postValue(State.Success(results))
        }
    }

    private fun onGetComicsSuccess(comics: BaseResponse<ComicModel>) {
        _searchList.postValue(State.Success(comics.data?.results ?: listOf()))
    }

    private fun onGetComicsError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }

    private fun getSeriesData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchSeries(text)
            .addSchedulers()
            .subscribe(::onGetSeriesSuccess, ::onGetSeriesError)
            .addTo(disposable)
    }

    private fun onGetSeriesSuccess(series: BaseResponse<SeriesModel>) {
        _searchList.postValue(State.Success(series.data?.results ?: listOf()))
    }

    private fun onGetSeriesError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }


    private fun getEventData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchEvents(text)
            .addSchedulers()
            .subscribe(::onGetEventSuccess, ::onGetEventError)
            .addTo(disposable)
    }

    private fun onGetEventSuccess(events: BaseResponse<EventModel>) {
        _searchList.postValue(State.Success(events.data?.results ?: listOf()))
    }


    private fun onGetEventError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))
    }

    private fun getCharacterData() {
        _searchList.postValue(State.Loading)
        searchText.value?.let {
            repository.searchCharacters(it)
                .addSchedulers()
                .subscribe(::onGetCharacterSuccess, ::onGetCharacterError)
                .addTo(disposable)
        }
    }

    private fun onGetCharacterSuccess(character: BaseResponse<CharactersModel>) {
        _searchList.postValue(State.Success(character.data?.results ?: listOf()))
    }


    private fun onGetCharacterError(throwable: Throwable) {
        _searchList.postValue(State.Error(throwable.message.toString()))

    }

    fun onClickComicChip() {
        _searchStatus.postValue(SearchStatus.COMIC)
        getComicData()
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
        getCharacterData()
    }

    override fun onCharacterClick(character: CharacterEntity) {
        _characterEvent.postValue(Event(character))
    }

    override fun onComicClick(comic: ComicEntity) {
        _comicEvent.postValue(Event(comic))
    }

    override fun onEventClick(event: EventEntity) {
        _eventEvent.postValue(Event(event))
    }

    override fun onSeriesClick(series: SeriesEntity) {
        _seriesEvent.postValue(Event(series))
    }

}

