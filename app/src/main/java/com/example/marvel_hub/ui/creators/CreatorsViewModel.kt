package com.example.marvel_hub.ui.creators

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.CreatorModel
import com.example.marvel_hub.data.model.base.BaseResponse
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.util.UiState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CreatorsViewModel : BaseViewModel() {


    private val _creator = MutableLiveData<UiState<BaseResponse<CreatorModel?>>>(UiState.Loading)
    val creator: LiveData<UiState<BaseResponse<CreatorModel?>>>
        get() = _creator

    fun getCreator() {
        disposable.add(
            repository.getAllCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetCreatorsSuccess, ::onGetCreatorsFail)
        )

    }

    private fun onGetCreatorsSuccess(creators: BaseResponse<CreatorModel?>) {
        _creator.postValue( UiState.Success(creators))

    }

    private fun onGetCreatorsFail(error: Throwable) {
        _creator.postValue(UiState.Error(error.message.toString()))
    }

}