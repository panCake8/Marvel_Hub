package com.example.marvel_hub.ui.aboutmarvel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.ui.aboutmarvel.adapter.OnClickCreator
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class AboutMarvelViewModel: BaseViewModel(), OnClickCreator {


    private val _marvel = MutableLiveData<State<BaseResponse<CreatorModel>>>(State.Loading)
    val marvel: LiveData<State<BaseResponse<CreatorModel>>>
        get() = _marvel


    private val _selectedCreatorItem = MutableLiveData<Event<CreatorModel>>()
    val selectedMarvelItem: LiveData<Event<CreatorModel>>
        get() = _selectedCreatorItem

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
        _marvel.postValue(State.Success(marvelResponse))
    }

    fun onFaild(message: Throwable) {
        _marvel.postValue(message.localizedMessage?.let { State.Error(it) })
    }

    override fun onClickCreatorItem(creator: CreatorModel) {
        _selectedCreatorItem.postValue(Event(creator))
    }


}