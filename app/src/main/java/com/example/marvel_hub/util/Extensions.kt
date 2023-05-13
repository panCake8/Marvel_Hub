package com.example.marvel_hub.util

import com.example.marvel_hub.data.enums.AnswerState
import com.example.marvel_hub.data.model.AnswerModel
import com.example.marvel_hub.data.model.CharactersModel

fun CharactersModel.toAnswer(isCorrect: Boolean, answerState: AnswerState = AnswerState.UNSELECTED, isDeleted : Boolean = false) =
    AnswerModel(this.name!!, isCorrect, answerState, isDeleted)
