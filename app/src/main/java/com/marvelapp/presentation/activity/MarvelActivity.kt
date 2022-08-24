package com.marvelapp.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.marvelapp.data.MarvelStates
import com.marvelapp.databinding.ActivityMainBinding
import com.marvelapp.presentation.view.MarvelView
import com.marvelapp.presentation.viewModel.MarvelViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MarvelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val marvelViewModel: MarvelViewModel by viewModels()
    private val view: MarvelView by lazy {
        MarvelView(binding, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                marvelViewModel.state.collect {
                    if (it.animation == MarvelStates.START_ANIMATION) {
                        view.startAnimation()
                    }
                }
            }
        }
    }
}
