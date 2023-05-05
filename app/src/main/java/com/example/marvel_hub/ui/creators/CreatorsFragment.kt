package com.example.marvel_hub.ui.creators

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FramentCreatorsBinding
import com.example.marvel_hub.ui.base.BaseFragment

class CreatorsFragment : BaseFragment<FramentCreatorsBinding, CreatorsViewModel>() {

    override val viewModel: CreatorsViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.frament_creators

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.textAboutCreatorGraph.movementMethod = ScrollingMovementMethod()

    }

}