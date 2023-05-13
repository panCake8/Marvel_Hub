package com.example.marvel_hub.ui

import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.ActivityHomeBinding
import com.example.marvel_hub.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    private lateinit var navController: NavController
    override val layoutId: Int
        get() = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        navController = findNavController(R.id.fragment_container)
        binding.navBottom.setupWithNavController(navController)
        navBottomVisibility()
    }

     fun navBottomVisibility() {
        if (
            navController.currentDestination?.displayName == HOME
            || navController.currentDestination?.displayName == SEARCH
            || navController.currentDestination?.displayName == ABOUT_MARVEL
        )
            binding.navBottom.visibility = View.VISIBLE
        else
            binding.navBottom.visibility = View.GONE
    }

    companion object {
        private const val HOME = "com.example.marvel_hub:id/homeFragment"
        private const val SEARCH = "com.example.marvel_hub:id/searchFragment"
        private const val ABOUT_MARVEL = "com.example.marvel_hub:id/fragmentAboutMarvel"
    }
}