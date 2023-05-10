package com.example.marvel_hub.ui.details.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.BaseResponse
import com.example.marvel_hub.data.model.CharactersModel
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.model.EventModel
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.data.model.StoriesModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel

class StoriesDetailsViewModel:BaseViewModel() {

    private val _stories =
        MutableLiveData<DataState<BaseResponse<StoriesModel>>>()

    val stories : LiveData<DataState<BaseResponse<StoriesModel>>>
        get() = _stories


    private val _character =
        MutableLiveData<DataState<BaseResponse<CharactersModel>>>(DataState.Loading)
    val character: LiveData<DataState<BaseResponse<CharactersModel>>>
        get() = _character


    private val _comics =
        MutableLiveData<DataState<BaseResponse<ComicModel>>>(DataState.Loading)
    val comics: LiveData<DataState<BaseResponse<ComicModel>>>
        get() = _comics


    private val _series =
        MutableLiveData<DataState<BaseResponse<SeriesModel>>>(DataState.Loading)
    val series: LiveData<DataState<BaseResponse<SeriesModel>>>
        get() = _series

    private val _events =
        MutableLiveData<DataState<BaseResponse<EventModel>>>(DataState.Loading)
    val events: LiveData<DataState<BaseResponse<EventModel>>>
        get() = _events




}