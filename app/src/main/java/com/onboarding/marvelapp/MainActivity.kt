package com.example.marvelapp

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.onboarding.marvelapp.R
import com.onboarding.marvelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.marvelLogoSplashImageView.startAnimation(
            AnimationUtils.loadAnimation(
                this,
                R.anim.vertical_slide
            )
        )
    }
}
