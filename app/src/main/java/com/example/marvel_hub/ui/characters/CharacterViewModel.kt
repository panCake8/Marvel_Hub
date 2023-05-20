package com.example.marvel_hub.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.CharacterListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject
@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: IMarvelRepository,
): BaseViewModel(), CharacterListener {

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
            .addSchedulers()
            .subscribe(::onSuccess, ::onError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(hero: BaseResponse<CharactersModel>) {
        _character.postValue(hero.data?.results?.let { State.Success(it) })
    }

    private fun onError(error: Throwable) {
        _character.postValue(error.message.toString().let { State.Error(it) })
    }

    override fun onCharacterClick(character: CharactersModel) {
        _selectedCharacterItem.postValue(Event(character.id))
    }

}