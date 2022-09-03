package com.marvelapp.presentation.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.marvelapp.R
import com.marvelapp.data.MarvelStates
import com.marvelapp.databinding.ActivitySplashBinding
import com.marvelapp.presentation.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        splashViewModel.startAnimation()
        binding.apply {
            startAnimation()
        }
    }

    private fun startAnimation() {
        val context = this
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.vertical_slide)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                splashViewModel.state.collect {
                    if (it.animation == MarvelStates.START_ANIMATION) {
                        binding.marvelLogoSplashImageView.startAnimation(slideAnimation)
                        Handler(Looper.getMainLooper()).postDelayed({
                            MarvelActivity.launch(context)
                            finish()
                        }, 3000)
                    }
                }
            }
        }
    }
}
