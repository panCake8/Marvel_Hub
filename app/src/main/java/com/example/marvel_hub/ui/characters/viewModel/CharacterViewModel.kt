package com.example.marvel_hub.ui.characters.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.util.State
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.characters.adapter.CharacterInteractionListener
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class CharacterViewModel : BaseViewModel(), CharacterInteractionListener {

    private val _characterMarvel =
        MutableLiveData<State<BaseResponse<CharactersModel>>>(State.Loading)
    val characterMarvel: LiveData<State<BaseResponse<CharactersModel>>> = _characterMarvel

    private val _selectedCharacterItem = MutableLiveData<Event<Int?>>()
    val selectedCharacterItem: LiveData<Event<Int?>> get() = _selectedCharacterItem

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
        _characterMarvel.postValue(State.Success(character))
    }

    private fun onError(throwable: Throwable) {
        _characterMarvel.postValue(State.Error(throwable.message.toString()))
    }

    override fun onClickCharacterItem(character: CharactersModel) {
        _selectedCharacterItem.postValue(Event(character.id))
    }

}