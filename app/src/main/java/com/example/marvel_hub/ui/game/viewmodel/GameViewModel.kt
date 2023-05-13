package com.example.marvel_hub.ui.game.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.enums.AnswerState
import com.example.marvel_hub.data.enums.GameState
import com.example.marvel_hub.data.model.AnswerModel
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.Thumbnail
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class GameViewModel: BaseViewModel() {
    private val _characterMarvel =
        MutableLiveData<State<BaseResponse<CharactersModel>>>(State.Loading)
    val characterMarvel: LiveData<State<BaseResponse<CharactersModel>>> = _characterMarvel

    private val _imageQuestion = MutableLiveData<Thumbnail>()
    val imageQuestion: LiveData<Thumbnail> = _imageQuestion

    private val _currentQuestionAnswers = MutableLiveData<List<AnswerModel>>()
    val currentQuestionAnswers: LiveData<List<AnswerModel>> get() = _currentQuestionAnswers

    private var _correctAnswersCount = MutableLiveData(0)
    val correctAnswersCount: LiveData<Int> get() = _correctAnswersCount

    private val _currentQuestionIndex = MutableLiveData(0)
    val currentQuestionIndex: LiveData<Int> get() = _currentQuestionIndex

    private val _isGameOver = MutableLiveData<Event<GameState>>()
    val isGameOver: LiveData<Event<GameState>> get() = _isGameOver

    private val _isQuestionClickable = MutableLiveData(true)
    val isQuestionClickable: LiveData<Boolean> get() = _isQuestionClickable

    private val allMCQsList = mutableListOf<CharactersModel>()

    init {
        getAllCharactersMarvel()
    }

    private fun getAllCharactersMarvel() {
        repository.getAllGameCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onGetQuestionsSuccess, ::onGetQuestionError)
            .addTo(compositeDisposable = disposable)
    }

    private fun onGetQuestionsSuccess(state: State<BaseResponse<CharactersModel>>) {
        if (state is State.Success) {
            generateQuestion(state)
        } else {
            _characterMarvel.postValue(state)
        }
    }

    private fun onGetQuestionError(throwable: Throwable) {
        _characterMarvel.postValue(State.Error(requireNotNull(throwable.message)))
    }

    private fun generateQuestion(state: State<BaseResponse<CharactersModel>>) {
        _characterMarvel.postValue(state)
        setCurrentImageQuestion(allMCQsList.first())
        setCurrentQuestionAnswers(allMCQsList)
    }

    private fun setCurrentImageQuestion(character: CharactersModel) {
        _imageQuestion.postValue(character.thumbnail!!)
    }

    private fun setCurrentQuestionAnswers(characters: List<CharactersModel>?) {
        if (characters != null && characters.isNotEmpty()) {

            val correctCharacter = characters.first()
            val incorrectCharacters = characters.drop(1).take(3)

            val answersList = incorrectCharacters.map { it.toAnswer(false) }
                .plus(correctCharacter.toAnswer(true))
                .shuffled()

            _currentQuestionAnswers.postValue(answersList)

        } else {
            reportError(NullPointerException(Constants.DATA_IS_NULL_ERROR_MESSAGE))
        }
    }

    private fun reportError(error: Throwable) {
        _characterMarvel.postValue(State.Error(error.message.toString()))
    }

    fun onAnswerClick(answer: AnswerModel) {
        _isQuestionClickable.postValue(false)
        if (answer.isCorrect) {
            onAnswerCorrectly(answer)
        } else {
            onAnswerWrongly(answer)
        }
    }

    private fun onAnswerCorrectly(answer: AnswerModel) {
        _currentQuestionAnswers.postValue(_currentQuestionAnswers.value?.apply {
            answer.state = AnswerState.SELECTED_CORRECT
        })

        _correctAnswersCount.postValue(_correctAnswersCount.value?.plus(1))

        if (isNotLastQuestion()){
            goToNextQuestion()
        } else {
            endGame()
        }
    }

    private fun isNotLastQuestion(): Boolean {
        return requireNotNull(currentQuestionIndex.value) < allMCQsList.lastIndex
    }

    private fun goToNextQuestion() {
        onComplete()
        _currentQuestionIndex.value = _currentQuestionIndex.value?.plus(1)
        doAfterDelay(Constants.ONE_SECOND) {
            _isQuestionClickable.postValue(true)
            _currentQuestionIndex.value?.let { setCurrentImageQuestion(allMCQsList[it]) }
        }
    }

    private fun onAnswerWrongly(answer: AnswerModel) {
        _currentQuestionAnswers.postValue(_currentQuestionAnswers.value?.apply {
            answer.state = AnswerState.SELECTED_INCORRECT
            endGame()
            this.filter { it.isCorrect }.forEach { it.state = AnswerState.SELECTED_CORRECT }
        })
    }

    private fun endGame() {
        doAfterDelay(Constants.ONE_SECOND) {
            if (requireNotNull(_correctAnswersCount.value ) > Constants.MINIMUM_REQUIRED_CORRECT_ANSWERS_TO_PASS){
                _isGameOver.postEvent(GameState.WIN)
            }else{
                _isGameOver.postEvent(GameState.LOSS)
            }
        }
    }

    private fun onComplete() {
        endGame()
    }


}