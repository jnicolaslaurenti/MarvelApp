package com.marvelapp.presentation.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marvelapp.R

class MarvelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marvel)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MarvelActivity::class.java)
    }
}