package com.example.marvel_hub.ui.game.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.State
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class GameViewModel: BaseViewModel() {
    private val _characterMarvel =
        MutableLiveData<State<BaseResponse<CharactersModel>>>(State.Loading)
    val characterMarvel: LiveData<State<BaseResponse<CharactersModel>>> = _characterMarvel

    init {
        getAllCharactersMarvel()
    }

    private fun getAllCharactersMarvel() {
        repository.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetQuestionsSuccess, ::onGetQuestionError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onGetQuestionsSuccess(state: State<BaseResponse<CharactersModel>>) {

    }

    private fun onGetQuestionError(throwable: Throwable) {

    }

}