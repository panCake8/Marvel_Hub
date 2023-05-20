package com.example.marvel_hub.ui.adapters

import androidx.recyclerview.widget.DiffUtil

class MatchDiffUtils<T>(
    private val oldList: List<T>,
    private val newList: List<T>,
    val checkIfTheSameItem: (oldItem: T, newItem: T) -> Boolean
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        checkIfTheSameItem(oldList[oldItemPosition], newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}