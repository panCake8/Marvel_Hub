package com.example.marvel_hub.ui.base

import androidx.lifecycle.ViewModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.data.repository.MarvelRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel() {

    protected val repository: IMarvelRepository = MarvelRepository()

    protected val disposables = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}