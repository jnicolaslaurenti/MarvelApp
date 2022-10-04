package com.marvelapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainMenuViewModelTest {

    private val mainMenuViewModel = MainMenuViewModel()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `change screen when the button is pressed`() {
        mainMenuViewModel.goToCharacterScreen()
        Assert.assertEquals(
            MainMenuViewModel.MainMenuStates.BUTTON_PRESSED,
            mainMenuViewModel.state.value
        )
    }
}
