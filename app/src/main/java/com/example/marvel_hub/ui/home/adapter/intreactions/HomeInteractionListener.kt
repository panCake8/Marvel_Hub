package com.example.marvel_hub.ui.home.adapter.intreactions


import com.example.marvel_hub.ui.home.adapter.BaseInteractListener

interface HomeInteractionListener : BaseInteractListener {
    fun onEventItemClick(id: Int)
    fun onComicItemClick(id: Int)
    fun onCharacterItemClick(id: Int)
}