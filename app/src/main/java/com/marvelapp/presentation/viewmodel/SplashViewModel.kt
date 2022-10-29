package com.marvelapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(SplashStates.START_ANIMATION)
    val state: StateFlow<SplashStates> = _state.asStateFlow()

    fun runAnimation() = viewModelScope.launch {
        delay(SPLASH_DELAY)
        _state.update { SplashStates.FINISH_ANIMATION }
    }

    enum class SplashStates {
        START_ANIMATION,
        FINISH_ANIMATION,
    }

    companion object {
        const val SPLASH_DELAY: Long = 3000
    }
}
