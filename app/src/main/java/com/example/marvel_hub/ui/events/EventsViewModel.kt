package com.example.marvel_hub.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.EventsListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val repository: IMarvelRepository,
) : BaseViewModel(), EventsListener {

    private val _event = MutableLiveData<State<EventModel>>(State.Loading)
    val event: LiveData<State<EventModel>>
        get() = _event


    private val _selectedEventItem = MutableLiveData<Event<Int?>>()
    val selectedEventItem: LiveData<Event<Int?>>
        get() = _selectedEventItem

    init {
        getAllEvents()
    }


    private fun getAllEvents() {
        repository.getAllEvents()
            .addSchedulers()
            .subscribe(::onEventSuccess, ::onError)
            .addTo(disposable)
    }

    private fun onEventSuccess(events: BaseResponse<EventModel>) {
        _event.postValue(events.data?.results?.let { State.Success(it) })

    }

    private fun onError(error: Throwable) {
        _event.postValue(error.message.toString().let { State.Error(it) })
    }

    override fun onEventClick(event: EventModel) {
        _selectedEventItem.postValue(Event(event.id))
    }

}