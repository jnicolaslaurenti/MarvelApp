package com.marvelapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marvelapp.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
