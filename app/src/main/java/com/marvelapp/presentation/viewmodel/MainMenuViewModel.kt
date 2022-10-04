package com.marvelapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainMenuStates.INIT)
    val state: StateFlow<MainMenuStates> = _state.asStateFlow()

    enum class MainMenuStates {
        INIT
    }
}
