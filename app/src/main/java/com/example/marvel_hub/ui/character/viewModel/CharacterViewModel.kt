package com.example.marvel_hub.ui.character.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponseData
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.character.adapter.CharacterInteractionListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterViewModel : BaseViewModel(), CharacterInteractionListener {

    private val _characterMarvel = MutableLiveData<DataState<BaseResponseData<CharactersModel?>>>()
    val characterMarvel: LiveData<DataState<BaseResponseData<CharactersModel?>>> = _characterMarvel

    init {
        getAllCharactersMarvel()
    }

    private fun getAllCharactersMarvel() {
        _characterMarvel.postValue(DataState.Loading)
        repository.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(character: CharactersModel) {
        _characterMarvel.postValue(DataState.Success())
    }

    private fun onError(throwable: Throwable) {
        _characterMarvel.postValue(DataState.Error(throwable.message.toString()))
    }

    override fun onClickCharacter(character: CharactersModel) {
    _characterMarvel.postValue()
    }

}