package com.example.marvel_hub.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marvel_hub.BR
import com.example.marvel_hub.ui.adapters.MatchDiffUtils

abstract class BaseAdapter<T>(
    private var items: List<T>,
    private val listener: BaseAdapterListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {
    abstract val getLayoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> bind(holder, position)
        }
    }

    open fun bind(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            val currentItem = items[position]
            setVariable(BR.item, currentItem)
            setVariable(BR.listener, listener)
        }
    }

    override fun getItemCount() = items.size

    open fun setItems(newItems: List<T>) {
        val diffUtils = DiffUtil.calculateDiff(MatchDiffUtils(items, newItems) { oldItem, newItem ->
            areTheSameItem(oldItem, newItem)
        })
        items = newItems
        diffUtils.dispatchUpdatesTo(this)
    }

    private fun areTheSameItem(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true
    interface BaseAdapterListener

    abstract class BaseViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)


}