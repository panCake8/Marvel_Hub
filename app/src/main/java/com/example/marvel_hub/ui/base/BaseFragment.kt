package com.example.marvel_hub.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.marvel_hub.BR


abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: VDB? = null
    protected val binding
        get() = _binding!!

    abstract val viewModel: VM

    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        requireNotNull(_binding).apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, viewModel)
            return root
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}