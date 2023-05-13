package com.example.marvel_hub.ui

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ActivityHomeBinding
import com.example.marvel_hub.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }
}