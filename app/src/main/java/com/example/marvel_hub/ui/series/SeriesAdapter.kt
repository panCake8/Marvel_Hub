package com.example.marvel_hub.ui.series

import com.example.marvel_hub.R
import com.example.marvel_hub.data.model.SeriesModel
import com.example.marvel_hub.ui.base.BaseAdapter

class SeriesAdapter(series: List<SeriesModel>,listener: SeriesInteractionListener): BaseAdapter<SeriesModel>(series,listener) {

    override val getLayoutId: Int
        get() = R.layout.item_series_card

}

interface SeriesInteractionListener: BaseAdapter.BaseAdapterListener{
    fun onClickSeries(series: SeriesModel)
}

