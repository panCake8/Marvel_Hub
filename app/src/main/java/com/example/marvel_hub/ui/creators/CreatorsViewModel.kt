package com.example.marvel_hub.ui.creators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.base.BaseResponse
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CreatorsViewModel : BaseViewModel() {

    private val _creator = MutableLiveData<BaseResponse<CreatorModel>>()
    val creator: LiveData<BaseResponse<CreatorModel>>
        get() = _creator

    fun getCreator() {
        disposable.add(
            repository.getAllCreators()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsFail)
        )

    }

    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel>) {
        _creator.postValue( creators)

    }

    private fun onGetCreatorsFail(throwable: Throwable) {
    }
}