package com.example.marvel_hub.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.marvel_hub.R

abstract class BaseActivity<VD : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: VD

    abstract val viewModel: VM

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

    }

}