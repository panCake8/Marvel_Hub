package com.example.marvel_hub.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.util.Event
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class SeriesViewModel: BaseViewModel(), SeriesInteractionListener {

    private val _series = MutableLiveData<DataState<BaseResponse<SeriesModel>>>(DataState.Loading)
    val series: LiveData<DataState<BaseResponse<SeriesModel>>>
        get() = _series

    private val _selectedSeriesItem = MutableLiveData<Event<SeriesModel>>()
    val selectedSeriesItem : LiveData<Event<SeriesModel>>
        get() = _selectedSeriesItem

    init {
        getAllSeries()
    }

    private fun getAllSeries() {
        repository.getAllSeries()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess,::onFail).addTo(disposable)
    }

    private fun onSuccess(series: BaseResponse<SeriesModel>){
        _series.postValue(DataState.Success(series))
    }

    private fun onFail(error: Throwable){
        _series.postValue(DataState.Error(error.message.toString()))
    }

    override fun onClickSeries(series: SeriesModel) {
        _selectedSeriesItem.postValue(Event(series))
    }
}