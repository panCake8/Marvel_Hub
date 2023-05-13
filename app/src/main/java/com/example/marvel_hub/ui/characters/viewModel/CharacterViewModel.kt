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

    private val _character = MutableLiveData<State<CharactersModel?>>(State.Loading)
    val character: LiveData<State<CharactersModel?>>
        get() = _character

    private val _selectedCharacterItem = MutableLiveData<Event<Int?>>()
    val selectedCharacterItem: LiveData<Event<Int?>> get() = _selectedCharacterItem

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        repository.getAllCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(hero: BaseResponse<CharactersModel>) {
        _character.postValue(hero.data?.results?.let { State.Success(it) })
    }

    private fun onError(error: Throwable) {
        _character.postValue(error.message.toString().let { State.Error(it) })
    }

    override fun onClickCharacterItem(character: CharactersModel) {
        _selectedCharacterItem.postValue(Event(character.id))
    }

}