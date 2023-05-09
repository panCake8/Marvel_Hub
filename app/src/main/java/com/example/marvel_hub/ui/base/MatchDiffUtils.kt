package com.example.marvel_hub.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.example.marvel_hub.data.model.base.IResponseItem

class MatchDiffUtils<T>(val oldList: List<T>, val newList: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition] as IResponseItem).id == (newList[newItemPosition] as IResponseItem).id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}