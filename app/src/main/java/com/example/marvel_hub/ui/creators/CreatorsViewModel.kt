package com.example.marvel_hub.ui.creators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.data.util.DataState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CreatorsViewModel : BaseViewModel() {


    private val _creator =
        MutableLiveData<DataState<BaseResponse<CreatorModel>>>(DataState.Loading)
    val creator: LiveData<DataState<BaseResponse<CreatorModel>>>
        get() = _creator

    fun getCreator( id :Int) {
        disposable.add(
            repository.getCreatorById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsFail)
        )

    }

    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel>) {
        _creator.postValue(DataState.Success(creators))

    }

    private fun onGetCreatorsFail(error: Throwable) {
        _creator.postValue(DataState.Error(error.message.toString()))
    }

}