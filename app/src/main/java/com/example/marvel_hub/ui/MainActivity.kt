package com.example.marvel_hub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.marvel_hub.R

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        mainViewModel.getMarvelCharacter()
        mainViewModel.marvelCharacter.observe(this@MainActivity) {
            tv.text = it.data?.results?.get(0)?.name.toString()
        }
    }
}