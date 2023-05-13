package com.example.marvel_hub.ui.aboutmarvel


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_hub.R
import com.example.marvel_hub.databinding.FragmentAboutMarvelBinding
import com.example.marvel_hub.ui.aboutmarvel.viewModel.AboutMarvelViewModel
import com.example.marvel_hub.ui.base.BaseFragment

class FragmentAboutMarvel : BaseFragment<FragmentAboutMarvelBinding, AboutMarvelViewModel>() {

    override val viewModel: AboutMarvelViewModel by viewModels()

    override val layoutId: Int get() = R.layout.fragment_about_marvel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGoToWebsite.setOnClickListener {
            intentMarvelSite()
        }

    }

    private fun intentMarvelSite(){
        val url = "https://www.marvel.com"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}
