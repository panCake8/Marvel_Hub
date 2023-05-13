package com.example.marvel_hub.data.model

import com.example.marvel_hub.data.enums.AnswerState

data class AnswerModel(val answer: String,
                       val isCorrect: Boolean,
                       var state: AnswerState,
                       var isDeleted : Boolean = false)
