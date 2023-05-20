package com.example.marvel_hub.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.repository.IMarvelRepository
import com.example.marvel_hub.ui.base.BaseViewModel
import com.example.marvel_hub.ui.listeners.SeriesListener
import com.example.marvel_hub.util.Event
import com.example.marvel_hub.util.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    private val repository: IMarvelRepository,
) : BaseViewModel(), SeriesListener {

    private val _series = MutableLiveData<State<SeriesModel>>(State.Loading)
    val series: LiveData<State<SeriesModel>>
        get() = _series

    private val _selectedSeriesItem = MutableLiveData<Event<Int?>>()
    val selectedSeriesItem: LiveData<Event<Int?>>
        get() = _selectedSeriesItem

    init {
        getAllSeries()
    }

    private fun getAllSeries() {
        repository.getAllSeries()
            .addSchedulers()
            .subscribe(::onSuccess, ::onFail)
            .addTo(compositeDisposable = disposable)
    }

    private fun onSuccess(series: BaseResponse<SeriesModel>) {
        _series.postValue(State.Success(series.data?.results))
    }

    private fun onFail(error: Throwable) {
        _series.postValue(State.Error(error.message.toString()))
    }

    override fun onSeriesClick(series: SeriesModel) {
        _selectedSeriesItem.postValue(Event(series.id))
    }
}