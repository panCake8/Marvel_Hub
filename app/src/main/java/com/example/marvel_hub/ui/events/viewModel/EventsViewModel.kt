package com.example.marvel_hub.ui.events.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.base.BaseModel
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class EventsViewModel : BaseViewModel() {
    private val events = MutableLiveData<List<EventModel?>?>()

    init {
        fetchAllEvents()
    }

    @SuppressLint("CheckResult")
    fun fetchAllEvents() {
        repository.getAllEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::success, ::failure)
    }

    private fun success(response: BaseModel<EventModel>) {
        Log.i("TAG", "response Successful : ${response.data?.results?.size}")
        events.postValue(response.data?.results)

    }

    private fun failure(T: Throwable) {
        Log.i("TAG", "failed : ${T.message}")

    }

}