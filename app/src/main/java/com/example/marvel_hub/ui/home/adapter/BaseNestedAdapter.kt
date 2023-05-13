package com.example.marvel_hub.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

abstract class BaseNestedAdapter<T>(
    private val listener: BaseInteractListener
) : RecyclerView.Adapter<BaseNestedAdapter.BaseViewHolder>() {

    @get:LayoutRes
    abstract val layoutId: Int
    private var items: List<T> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun getItems() = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when (holder) {
            is ItemViewHolder -> {
                holder.binding.setVariable(com.example.marvel_hub.BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    override fun getItemCount() = items.size ?: 0

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    open class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)
}

interface BaseInteractListener