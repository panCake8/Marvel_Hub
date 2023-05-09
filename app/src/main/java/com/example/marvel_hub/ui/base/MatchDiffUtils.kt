package com.example.marvel_hub.ui.base

import androidx.recyclerview.widget.DiffUtil

class MatchDiffUtils<T>(val oldList: List<T>, val newList: List<T>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition]) == (newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}