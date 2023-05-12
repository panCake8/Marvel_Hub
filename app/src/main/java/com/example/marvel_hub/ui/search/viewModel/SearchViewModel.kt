package com.example.marvel_hub.ui.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.util.State
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.search.adapter.interactions.CharacterInteractionListener
import com.example.marvel_hub.ui.search.adapter.interactions.ComicInteractionListener
import com.example.marvel_hub.ui.search.adapter.interactions.EventInteractionListener
import com.example.marvel_hub.ui.search.adapter.interactions.SeriesInteractionListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel : BaseViewModel(), EventInteractionListener,
    ComicInteractionListener,
    SeriesInteractionListener, CharacterInteractionListener {

    private val _searchStatus =
        MutableLiveData(SearchStatus.COMIC)
    val searchStatus: LiveData<SearchStatus>
        get() = _searchStatus

    private val _searchList = MutableLiveData<State<List<Any>>>(State.Loading)
    val searchList: LiveData<State<List<Any>>>
        get() = _searchList

    fun getComicData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchComics(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetComicsSuccess, ::onGetComicsError).addTo(disposable)
    }

    private fun onGetComicsSuccess(comics: BaseResponse<ComicModel>) {
        _searchList.postValue(State.Success(comics.data?.results ?: listOf()))
    }

    private fun onGetComicsError(throwable: Throwable) =
        State.Error(throwable.message.toString())

    fun getSeriesData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchSeries(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetSeriesSuccess, ::onGetSeriesError).addTo(disposable)
    }

    private fun onGetSeriesSuccess(series: BaseResponse<SeriesModel>) {
        _searchList.postValue(State.Success(series.data?.results ?: listOf()))
    }

    private fun onGetSeriesError(throwable: Throwable) =
        State.Error(throwable.message.toString())


    fun getEventData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchEvents(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetEventSuccess, ::onGetEventError).addTo(disposable)
    }

    private fun onGetEventSuccess(events: BaseResponse<EventModel>) {
        _searchList.postValue(State.Success(events.data?.results ?: listOf()))
    }


    private fun onGetEventError(throwable: Throwable) =
        State.Error(throwable.message.toString())

    fun getCharacterData(text: String) {
        _searchList.postValue(State.Loading)
        repository.searchCharacters(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetCharacterSuccess, ::onGetCharacterError).addTo(disposable)
    }

    private fun onGetCharacterSuccess(character: BaseResponse<CharactersModel>) {
        _searchList.postValue(State.Success(character.data?.results ?: listOf()))
    }


    private fun onGetCharacterError(throwable: Throwable) =
        State.Error(throwable.message.toString())

    fun onClickComicChip() {
        _searchStatus.postValue(SearchStatus.COMIC)
    }

    fun onClickEventChip() {
        _searchStatus.postValue(SearchStatus.EVENT)
    }

    fun onClickSeriesChip() {
        _searchStatus.postValue(SearchStatus.SERIES)
    }

    fun onClickCharacterChip() {
        _searchStatus.postValue(SearchStatus.CHARACTER)
    }

    override fun onClickComic(comic: ComicModel) {

    }

    override fun onClickEvent(event: EventModel) {

    }

    override fun onClickSeries(creator: SeriesModel) {
    }

    override fun onClickSeries(character: CharactersModel) {

    }
}

