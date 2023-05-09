package com.example.marvel_hub.ui.characters.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.characters.adapter.CharacterInteractionListener
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterViewModel : BaseViewModel(), CharacterInteractionListener {

    private val _characterMarvel =
        MutableLiveData<DataState<BaseResponse<CharactersModel>>>(DataState.Loading)
    val characterMarvel: LiveData<DataState<BaseResponse<CharactersModel>>> = _characterMarvel

    private val _eventCharacter = MutableLiveData<Event<Int?>>()
    val eventCharacter: LiveData<Event<Int?>> get() = _eventCharacter

    init {
        getAllCharactersMarvel()
    }

    private fun getAllCharactersMarvel() {
        repository.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(character: BaseResponse<CharactersModel>) {
        _characterMarvel.postValue(DataState.Success(character))
    }

    private fun onError(throwable: Throwable) {
        _characterMarvel.postValue(DataState.Error(throwable.message.toString()))
    }

    override fun onClickCharacter(character: CharactersModel) {
        _eventCharacter.postValue(Event(character.id))
    }

}