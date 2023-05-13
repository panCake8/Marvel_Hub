package com.example.marvel_hub.util

import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.enums.AnswerState
import com.example.marvel_hub.data.model.AnswerModel
import com.example.marvel_hub.data.model.CharactersModel

fun CharactersModel.toAnswer(isCorrect: Boolean, answerState: AnswerState = AnswerState.UNSELECTED, isDeleted : Boolean = false) =
    AnswerModel(this.name!!, isCorrect, answerState, isDeleted)

fun <T> MutableLiveData<Event<T>>.postEvent(content: T) {
    postValue(Event(content))
}
