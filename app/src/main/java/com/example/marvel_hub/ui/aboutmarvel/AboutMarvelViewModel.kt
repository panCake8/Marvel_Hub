package com.example.marvel_hub.ui.aboutmarvel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class AboutMarvelViewModel: BaseViewModel(), onClickMarvel {


    private val _Marvel = MutableLiveData<DataState<BaseResponse<CreatorModel>>>()
    val marvel: LiveData<DataState<BaseResponse<CreatorModel>>>
        get() = _Marvel


    private val _selectedMarvelItem = MutableLiveData<Event<CreatorModel>>()
    val selectedmarvelItem: LiveData<Event<CreatorModel>>
        get() = _selectedMarvelItem

    init {
        getMarvel()
    }

    private fun getMarvel() {
        repository.getAllCreators()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFaild)
            .addTo(compositeDisposable = disposable)

    }

    fun onSuccess(marvelResponse: BaseResponse<CreatorModel>) {
        _Marvel.postValue(DataState.Success(marvelResponse))
    }

    fun onFaild(message: Throwable) {
        _Marvel.postValue(message.localizedMessage?.let { DataState.Error(it) })
    }

    override fun onClickMarvel(marvel: CreatorModel) {
        _selectedMarvelItem.postValue(Event(marvel))
    }

}