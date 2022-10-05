package com.marvelapp.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.marvelapp.R
import com.marvelapp.databinding.ActivityMainMenuBinding
import com.marvelapp.presentation.viewmodel.MainMenuViewModel
import com.marvelapp.presentation.viewmodel.MainMenuViewModel.MainMenuStates.INIT
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    private val viewModel: MainMenuViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this)
            .load(R.drawable.spidey)
            .override(400)
            .into(binding.spideyGif)
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest { this@MainMenuActivity.updateUI(it) }
        }
    }

    private fun updateUI(state: MainMenuViewModel.MainMenuStates) {
        when (state) {
            INIT -> {
                // DO NOTHING
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainMenuActivity::class.java)
    }
}
