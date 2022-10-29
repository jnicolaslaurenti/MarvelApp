package com.marvelapp.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.marvelapp.data.CharacterEntity
import com.marvelapp.databinding.ActivityCharacterBinding
import com.marvelapp.presentation.adapter.CharacterAdapter
import com.marvelapp.presentation.viewmodel.CharacterViewModel
import com.marvelapp.presentation.viewmodel.CharacterViewModel.CharactersState.SHOW_CHARACTERS
import com.marvelapp.presentation.viewmodel.CharacterViewModel.CharactersState.INIT
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding
    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenStarted {
            viewModel.state.collectLatest { this@CharacterActivity.updateUI(it) }
        }
    }

    private fun updateUI(state: CharacterViewModel.CharactersData) {
        when (state.state) {
            INIT -> viewModel.showCharacters()
            SHOW_CHARACTERS -> showCharactersList(state.data)
        }
    }

    private fun showCharactersList(characters: List<CharacterEntity>) {
        binding.characterList.layoutManager = LinearLayoutManager(this)
        binding.characterList.adapter = CharacterAdapter(characters)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, CharacterActivity::class.java)
    }
}
