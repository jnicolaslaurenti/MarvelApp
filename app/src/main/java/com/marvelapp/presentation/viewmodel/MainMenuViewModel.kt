package com.marvelapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainMenuViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(MainMenuStates.WAITING)
    val state: StateFlow<MainMenuStates> = _state.asStateFlow()

    fun goToCharacterScreen() {
            _state.update { MainMenuStates.BUTTON_PRESSED }
        }

    enum class MainMenuStates {
        WAITING,
        BUTTON_PRESSED,
    }
}
