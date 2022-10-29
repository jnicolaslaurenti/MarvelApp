package com.marvelapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvelapp.data.CharacterEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor() : ViewModel() {

    private val charactersListTest = listOf(CharacterEntity("Batman", ""), CharacterEntity("Superman", ""))
    private val _state = MutableStateFlow(CharactersData(CharactersState.INIT))
    val state: StateFlow<CharactersData> = _state.asStateFlow()

    fun showCharacters() = viewModelScope.launch {
        _state.update { CharactersData(CharactersState.SHOW_CHARACTERS, charactersListTest) }
    }

    data class CharactersData(
        val state: CharactersState,
        val data: List<CharacterEntity> = listOf()
    )

    enum class CharactersState {
        INIT,
        SHOW_CHARACTERS
    }
}
