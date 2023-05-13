package com.example.marvel_hub.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.enums.AnswerState
import com.example.marvel_hub.data.model.AnswerModel
import com.example.marvel_hub.data.model.CharactersModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

fun CharactersModel.toAnswer(isCorrect: Boolean, answerState: AnswerState = AnswerState.UNSELECTED, isDeleted : Boolean = false) =
    AnswerModel(this.name!!, isCorrect, answerState, isDeleted)

fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}
fun <T : Any> Observable<T>.observeOnMainThread(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}
inline fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, crossinline onEventUnhandledContent: (T) -> Unit) {
    observe(owner) { it?.getContentIfNotHandled()?.let(onEventUnhandledContent) }
}