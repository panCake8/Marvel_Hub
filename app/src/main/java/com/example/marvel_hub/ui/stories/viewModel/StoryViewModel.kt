package com.example.marvel_hub.ui.stories.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.List
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.stories.adapter.StoriesInteractionListener
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class StoryViewModel : BaseViewModel(), StoriesInteractionListener {

    private val _story = MutableLiveData<DataState<List<StoriesModel>>>(DataState.Loading)
    val story: LiveData<DataState<List<StoriesModel>>>
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

    private fun onSuccess(story: List<StoriesModel>) {
        _story.postValue(DataState.Success(story))
    }

    private fun onFail(error: Throwable) {
        _story.postValue(DataState.Error(error.message.toString()))
    }

    override fun onClickStoryItem(story: StoriesModel) {
        _selectedStoryItem.postValue(Event(story))
    }
}