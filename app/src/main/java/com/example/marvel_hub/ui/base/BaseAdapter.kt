package com.example.marvel_hub.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<T>(
    private val items: List<T>,
    private val listener: BaseAdapterListener?
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

    override fun getItemCount() = items.size

    interface BaseAdapterListener

    abstract class BaseViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)
    class ItemViewHolder(binding: ViewDataBinding) : BaseViewHolder(binding)


}