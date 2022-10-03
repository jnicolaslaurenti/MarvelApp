package com.marvelapp.presentation.activity

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.marvelapp.R
import com.marvelapp.databinding.ActivitySplashBinding
import com.marvelapp.presentation.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenStarted {
            splashViewModel.state.collectLatest { this@SplashActivity.updateUI(it) }
        }
        splashViewModel.runAnimation()
    }

    private fun updateUI(state: SplashViewModel.SplashStates) {
        when (state) {
            SplashViewModel.SplashStates.START_ANIMATION -> {
                val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.vertical_slide)
                binding.marvelLogoSplashImageView.startAnimation(slideAnimation)
            }
            SplashViewModel.SplashStates.FINISH_ANIMATION -> {
                startActivity(MainMenuActivity.getIntent(this))
                finish()
            }
        }
    }
}
