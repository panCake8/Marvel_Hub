package com.example.marvel_hub.ui.stories.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.util.State
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.stories.adapter.StoriesInteractionListener
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class StoryViewModel : BaseViewModel(), StoriesInteractionListener {

    private val _story = MutableLiveData<State<BaseResponse<StoriesModel>>>(State.Loading)
    val story: LiveData<State<BaseResponse<StoriesModel>>>
        get() = _story

    private val _selectedStoryItem = MutableLiveData<Event<StoriesModel>>()
    val selectedStoryItem: LiveData<Event<StoriesModel>>
        get() = _selectedStoryItem

    init {
        getAllStories()
    }

    private fun getAllStories() {
        repository.getAllStories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFail)
            .addTo(disposable)
    }

    private fun onSuccess(story: BaseResponse<StoriesModel>) {
        _story.postValue(State.Success(story))
    }

    private fun onFail(error: Throwable) {
        _story.postValue(State.Error(error.message.toString()))
    }

    override fun onClickStoryItem(story: StoriesModel) {
        _selectedStoryItem.postValue(Event(story))
    }
}