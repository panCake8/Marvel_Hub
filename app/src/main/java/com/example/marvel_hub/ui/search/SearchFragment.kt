package com.example.marvel_hub.ui.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentSearchBinding
import com.example.marvel_hub.ui.base.BaseFragment
import com.example.marvel_hub.ui.search.viewModel.SearchViewModel
import com.google.android.material.chip.Chip
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_search


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        searchHandel()


        val debounceOperator = Observable.create { emitter ->
            binding.searchBar .doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())
            }
        }.debounce (1, TimeUnit.SECONDS)
        debounceOperator.subscribe { t -> Log.i("TAG", "on next:$t") }


    }

    }



    private fun searchHandel(){
        binding.searchBar.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Do something when the Enter key is pressed
                val inputText = binding.searchBar.text.toString()
                if(showSelectedChips() == "Comics"){
                    viewModel.searchInComics(inputText)
                }
                else if(showSelectedChips() == "Creators"){
                    viewModel.searchInCreators(inputText)
                }

                else if(showSelectedChips() == "Events"){
                    viewModel.searchInEvent(inputText)
                }


                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }
    }
    private fun showSelectedChips() :String{
        val selectedChipsIds = binding.filterChipComponent.checkedChipIds
        val selectedChips = mutableListOf<String>()
        for (id in selectedChipsIds) {
            val chip = binding.filterChipComponent.findViewById<Chip>(id)
            selectedChips.add(chip.text.toString())
        }
        return   selectedChips.joinToString(", ")
    }


}
