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

    private val _story = MutableLiveData<State<StoriesModel>>(State.Loading)
    val story: LiveData<State<StoriesModel>>
        get() = _story

    private val _selectedStoryItem = MutableLiveData<Event<Int?>>()
    val selectedStoryItem: LiveData<Event<Int?>>
        get() = _selectedStoryItem

    init {
        getAllStories()
    }

    private fun getAllStories() {
        repository.getAllStories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFail)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(story: BaseResponse<StoriesModel>) {
        _story.postValue(State.Success(story.data?.results))
    }

    private fun onFail(error: Throwable) {
        _story.postValue(State.Error(error.message.toString()))
    }

    override fun onClickStoryItem(story: StoriesModel) {
        _selectedStoryItem.postValue(Event(story.id))
    }
}