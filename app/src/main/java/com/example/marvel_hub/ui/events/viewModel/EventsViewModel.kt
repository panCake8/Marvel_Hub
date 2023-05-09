package com.example.marvel_hub.ui.events.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class EventsViewModel : BaseViewModel() {

    private val _events = MutableLiveData<DataState<BaseResponse<EventModel>>>()


    val event : LiveData<DataState<BaseResponse<EventModel>>>
        get() = _events



    init {
        fetchAllEvents()
    }

    @SuppressLint("CheckResult")
    fun fetchAllEvents() {
        repository.getAllEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::success, ::failure).addTo(disposable)
    }

    private fun success(response: BaseResponse<EventModel>) {
        Log.i("TAG", "response Successful : ${response.data?.results?.size}")
        _events.postValue(DataState.Success(response))

    }

    private fun failure(T: Throwable) {
        Log.i("TAG", "failed : ${T.message}")

    }

}