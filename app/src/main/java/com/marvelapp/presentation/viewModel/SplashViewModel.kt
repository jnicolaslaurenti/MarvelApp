package com.marvelapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(UiState(SplashStates.START_ANIMATION))
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun runAnimation() = viewModelScope.launch {
        delay(3000)
        _state.update { UiState(animation = SplashStates.FINISH_ANIMATION) }
    }

    data class UiState(val animation: SplashStates)

    enum class SplashStates {
        START_ANIMATION,
        FINISH_ANIMATION,
    }
}
