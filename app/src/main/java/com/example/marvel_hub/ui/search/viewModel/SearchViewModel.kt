package com.example.marvel_hub.ui.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.search.ComicInteractionListener
import com.example.marvel_hub.ui.search.adapter.CreatorInteractionListener
import com.example.marvel_hub.ui.search.adapter.EventInteractionListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel : BaseViewModel(), EventInteractionListener,
    ComicInteractionListener,
    CreatorInteractionListener {

    private val _dataType =
        MutableLiveData<Int>()
    val dataType: LiveData<Int> = _dataType


    private val _comics =
        MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<BaseResponse<ComicModel>>> = _comics

    private val _creators =
        MutableLiveData<DataState<BaseResponse<CreatorModel>>>(DataState.Loading)
    val creators: LiveData<DataState<BaseResponse<CreatorModel>>> = _creators

    private val _events =
        MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)
    val event: LiveData<DataState<BaseResponse<EventModel>>> = _events

    val searchInput = MutableLiveData<String>()


    init {

        getEvent("")
        getCreators("")
        getComics("")

    }


    private fun getComics(text: String) {
        disposable.add(
            repository.searchComics(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetComicsSuccess, ::onGetComicsError)
        )
    }

    private fun onGetComicsSuccess(comics: BaseResponse<ComicModel>) =
        _comics.postValue(DataState.Success(comics))

    private fun onGetComicsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    private fun getEvent(text: String) {
        disposable.add(
            repository.searchEvents(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetEventsSuccess, ::onGetEventsError)
        )
    }

    private fun onGetEventsSuccess(events: BaseResponse<EventModel>) =
        _events.postValue(DataState.Success(events))

    private fun onGetEventsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())

    private fun getCreators(text: String) {
        disposable.add(
            repository.searchCreators(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsError)
        )
    }


    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel>) =
        _creators.postValue(DataState.Success(creators))

    private fun onGetCreatorsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    fun onClickComicChip() {
        _dataType.postValue(1)
    }

    fun onClickEventChip() {
        _dataType.postValue(2)
    }

    fun onClickCreatorChip() {
        _dataType.postValue(3)
    }


    override fun onClickComic(comic: ComicModel) {

    }

    override fun onClickCreator(comic: CreatorModel) {

    }

    override fun onClickEvent(comic: EventModel) {

    }
}

