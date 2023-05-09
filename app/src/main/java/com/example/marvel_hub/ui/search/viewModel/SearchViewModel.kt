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


    private val _comics = MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<BaseResponse<ComicModel>>> = _comics

    private val _creators =
        MutableLiveData<DataState<BaseResponse<CreatorModel>>>(DataState.Loading)
    val creators: LiveData<DataState<BaseResponse<CreatorModel>>> = _creators

    private val _event = MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)
    val event: LiveData<DataState<BaseResponse<EventModel>>> = _event

    private val _searchInput = MutableLiveData<String>()
    val result: LiveData<String> = _searchInput

    fun searchInComics(text: CharSequence) {
        disposable.add(
            repository.searchComics(text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetComicsSuccess, ::onGetComicsError)
        )
    }

    fun searchInEvent(text: CharSequence) {
        disposable.add(
            repository.searchEvents(text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetEventsSuccess, ::onGetEventsError)
        )
    }

    fun searchInCreators(text: CharSequence) {
        disposable.add(
            repository.searchCreators(text.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsError)
        )
    }

    private fun onGetComicsSuccess(comics: BaseResponse<ComicModel>) =
        _comics.postValue(DataState.Success(comics))

    private fun onGetComicsError(throwable: Throwable) =
        DataState.Error(throwable.message.toString())


    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel>) =
        _creators.postValue(DataState.Success(creators))

    private fun onGetCreatorsError(throwable: Throwable) = DataState.Error(throwable.message.toString())


    private fun onGetEventsSuccess(events: BaseResponse<EventModel>) = _event.postValue(DataState.Success(events))

    private fun onGetEventsError(throwable: Throwable) = DataState.Error(throwable.message.toString())

    override fun onClickComic(comic: ComicModel) {

    }

    override fun onClickCreator(comic: CreatorModel) {
        TODO("Not yet implemented")
    }

    override fun onClickEvent(comic: EventModel) {
        TODO("Not yet implemented")
    }


}