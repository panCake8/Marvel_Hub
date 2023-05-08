package com.example.marvel_hub.ui.search.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.marvel_hub.data.model.ComicModel
import com.example.marvel_hub.data.util.DataState
import com.example.marvel_hub.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SearchViewModel: BaseViewModel() {
    private val _comics = MutableLiveData<DataState<ComicModel?>>(DataState.Loading)
    val comics :LiveData<DataState<ComicModel?>>
        get() = _comics
    fun getAllComics(){
        disposable.add(
            repository.getAllComics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onGetComicsSuccess,::onGetComicsError)
        )
    }
    private fun onGetComicsSuccess(comics:ComicModel){
        _comics.postValue(DataState.Success(comics.))
    }
    private fun onGetComicsError(){

    }
}