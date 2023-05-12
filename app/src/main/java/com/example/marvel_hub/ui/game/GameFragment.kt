package com.example.marvel_hub.ui.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentGameBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.game.viewmodel.GameViewModel


class GameFragment : BaseFragment<FragmentGameBinding, GameViewModel>() {
    override val viewModel: GameViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_game

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}