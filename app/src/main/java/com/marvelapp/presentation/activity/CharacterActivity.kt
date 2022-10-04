package com.marvelapp.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marvelapp.databinding.ActivityCharacterBinding

class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, CharacterActivity::class.java)
    }
}
