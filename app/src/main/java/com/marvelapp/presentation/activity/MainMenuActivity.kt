package com.marvelapp.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.marvelapp.databinding.ActivityMainMenuBinding
import com.marvelapp.presentation.viewmodel.MainMenuViewModel
import com.marvelapp.presentation.viewmodel.MainMenuViewModel.MainMenuStates.BUTTON_PRESSED
import com.marvelapp.presentation.viewmodel.MainMenuViewModel.MainMenuStates.WAITING
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class MainMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuBinding
    private val viewModel: MainMenuViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest { this@MainMenuActivity.updateUI(it) }
        }
        binding.nextScreenButton.setOnClickListener {
            viewModel.goToCharacterScreen()
        }
    }

    private fun updateUI(state: MainMenuViewModel.MainMenuStates) {
        when (state) {
            WAITING -> {
                // DO NOTHING
            }
            BUTTON_PRESSED ->
                goToCharacterScreen()
        }
    }

    private fun goToCharacterScreen() {

    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainMenuActivity::class.java)
    }
}
