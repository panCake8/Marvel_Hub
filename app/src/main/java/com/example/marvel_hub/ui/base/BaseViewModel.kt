package com.example.marvel_hub.ui.base

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


abstract class BaseViewModel : ViewModel() {


    protected val disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    protected fun <T : Any> Single<T>.applySchedulers(): Single<T> {
        return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}