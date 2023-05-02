package com.example.marvel_hub.ui.base

import androidx.lifecycle.ViewModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.data.repository.MarvelRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable


abstract class BaseViewModel : ViewModel() {

    protected val repository: IMarvelRepository = MarvelRepository()

    protected val disposable = CompositeDisposable()

    protected fun Disposable.addDisposable() {
        disposable.add(this@addDisposable)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}