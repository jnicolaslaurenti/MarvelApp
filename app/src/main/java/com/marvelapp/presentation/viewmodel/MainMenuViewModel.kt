package com.marvelapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainMenuStates.INIT)
    val state: StateFlow<MainMenuStates> = _state.asStateFlow()

    fun buttonPressed() =
        _state.update { MainMenuStates.GO_TO_CHARACTER_SCREEN }

    enum class MainMenuStates {
        INIT,
        GO_TO_CHARACTER_SCREEN
    }
}
