package com.example.marvel_hub.ui.events.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.events.event_recycler.EventsSeeAllListener
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class EventsViewModel : BaseViewModel(), EventsSeeAllListener {

    private val _events = MutableLiveData<DataState<List<EventModel>>>()
    val event: LiveData<DataState<List<EventModel>>>
        get() = _events




    fun fetchAllEvents() {
        repository.getAllEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onEventSuccess, ::onError)
            .addTo(disposable)
    }

    private fun onEventSuccess(events: BaseResponse<EventModel>) {

        Log.i("TAG", "response Successful : ${events.data?.results?.size}")
        _events.postValue(events.data?.results?.let { DataState.Success(it) })

    }

    private fun onError(T: Throwable) {
        Log.i("TAG", "failed : ${T.message}")
        _events.postValue(T.message.toString().let { DataState.Error(it) })
    }

    override fun onClick(event: EventModel) {
//        val fragment = EventsDetails()
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .addToBackStack(null)
//            .commit()
    }

}