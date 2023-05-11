package com.example.marvel_hub.ui.creators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.State
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CreatorsViewModel : BaseViewModel() {

    private val _creator = MutableLiveData<State<BaseResponse<CreatorModel>>>()
    val creator: LiveData<State<BaseResponse<CreatorModel>>>
        get() = _creator

    private val _selectedCreatorItem = MutableLiveData<Event<CreatorModel>>()
    val selectedCreatorItem: LiveData<Event<CreatorModel>>
        get() = _selectedCreatorItem


    fun getCreator( id :Int) {
        disposable.add(
            repository.getCreatorById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsFail)
        )

    }

    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel>) {
        _creator.postValue(State.Success(creators))

    }

    private fun onGetCreatorsFail(error: Throwable) {
        _creator.postValue(State.Error(error.message.toString()))
    }

}